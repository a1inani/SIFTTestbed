package io.github.a1inani.sifttestbed.activities;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import common.CSVUtils;
import common.EarFeature;
import common.SQLiteHandler;
import common.EarIdentifier;
import common.Patient;
import io.github.a1inani.sifttestbed.R;
import yogesh.firzen.filelister.FileListerDialog;
import yogesh.firzen.filelister.OnFileSelectedListener;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {
    ProgressDialog p;
    public static String pathname;
    public static String directory;
    SQLiteHandler db;
    double[][] scoreMatrix = new double[238][238];
    ArrayList<Patient> source = new ArrayList<>(), target = new ArrayList<>();
    //int count = 0;

    private static final int READ_REQUEST_CODE = 42;


    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        mVisible = true;
        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);

        findViewById(R.id.dummy_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickDirectory();

            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }

    /**
     * Schedules a call to hide() in delay milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent resultData) {
        super.onActivityResult(requestCode, resultCode, resultData);
    }

    public void pickDirectory() {
        FileListerDialog fileListerDialog = FileListerDialog.createFileListerDialog(this);
        fileListerDialog.setFileFilter(FileListerDialog.FILE_FILTER.DIRECTORY_ONLY);
        fileListerDialog.setOnFileSelectedListener(new OnFileSelectedListener() {
            @Override
            public void onFileSelected(File file, String path) {
                pathname = path;
                directory = file.getName();
                if(db.doesDatabaseExist(getApplicationContext(), directory)) {
                    db = new SQLiteHandler(getApplicationContext(), directory);
                    new FeatureMatching().execute();
                    //new Results().execute();
                    Log.d("Status", "Database exists");
                } else {
                    db = new SQLiteHandler(getApplicationContext(), directory);
                    FeatureExtraction fe = new FeatureExtraction();
                    Log.d("Path", pathname);
                    fe.execute(pathname);
                }
            }
        });
        fileListerDialog.show();
    }

    private class FeatureExtraction extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            File input1left = new File(strings[0]+"/input1left");
            File input1left30 = new File(strings[0]+"/input1left30");
            File input2left = new File(strings[0]+"/input2left");
            File input2left30 = new File(strings[0]+"/input2left30");
            featureExtraction(input1left);
            featureExtraction(input1left30);
            featureExtraction(input2left);
            featureExtraction(input2left30);
            return null;
        }

        public void featureExtraction(File dir) {
            if (dir.exists()) {
                File[] files = dir.listFiles();
                for (int i = 0; i < files.length; ++i) {
                    File file = files[i];
                    if (file.isDirectory()) {
                        featureExtraction(file);
                    } else {
                        EarIdentifier identifier = new EarIdentifier(null);
                        EarFeature earFeature = identifier.computePathFeatures(file.getPath());
                        Patient patient = new Patient();
                        String name = file.getName();
                        String caseId = name.substring(0, name.length()-4);
                        patient.setFileName(caseId);
                        patient.addFeature(earFeature);
                        if(caseId.charAt(0) == 'm') {
                            patient.setGender("male");
                        }
                        if(caseId.charAt(0) == 'f') {
                            patient.setGender("female");
                        }
                        Log.d("Status", "Adding patient to db");

                        if(dir.getName().equals("6W")) {
                            ContentValues values = new ContentValues();
                            values.put(db.COLUMN_FILE_NAME, patient.getFileName());
                            values.put(db.COLUMN_GENDER, patient.getGender());
                            values.put(db.COLUMN_FEATURE, patient.getFeatures().get(0).getFeatures());
                            db.getWritableDatabase().insert(db.TABLE_6WEEK_LEFT, null, values);
                        }
                        if(dir.getName().equals("6D")) {
                            ContentValues values = new ContentValues();
                            values.put(db.COLUMN_FILE_NAME, patient.getFileName());
                            values.put(db.COLUMN_GENDER, patient.getGender());
                            values.put(db.COLUMN_FEATURE, patient.getFeatures().get(0).getFeatures());
                            db.getWritableDatabase().insert(db.TABLE_6DAY_LEFT, null, values);
                        }
                        /*if(dir.getName().equals("9M_left30")) {
                            ContentValues values = new ContentValues();
                            values.put(db.COLUMN_FILE_NAME, patient.getFileName());
                            values.put(db.COLUMN_GENDER, patient.getGender());
                            values.put(db.COLUMN_FEATURE, patient.getFeatures().get(0).getFeatures());
                            db.getWritableDatabase().insert(db.TABLE_9MONTH_LEFT30, null, values);
                        }
                        if(dir.getName().equals("8M_left30")) {
                            ContentValues values = new ContentValues();
                            values.put(db.COLUMN_FILE_NAME, patient.getFileName());
                            values.put(db.COLUMN_GENDER, patient.getGender());
                            values.put(db.COLUMN_FEATURE, patient.getFeatures().get(0).getFeatures());
                            db.getWritableDatabase().insert(db.TABLE_8MONTH_LEFT30, null, values);
                        }*/
                    }
                }
            } else {
                Log.d("Debug", dir.toString());
                Log.d("Debug", "Directory does not exist");
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            p = new ProgressDialog(FullscreenActivity.this);
            p.setMessage("Image features are being extracted...");
            p.setIndeterminate(false);
            p.setCancelable(false);
            p.show();
        }

        @Override
        protected void onPostExecute(String s) {
            p.hide();
            new FeatureMatching().execute();

        }
    }

    String[] available = {
            "6D61",
            "6D39",
            "6D69",
            "6D115",
            "6D95",
            "6D26",
            "6D72",
            "6D62",
            "6D51",
            "6D139",
            "6D133",
            "6D137",
            "6D55",
            "6D65",
            "6D87",
            "6D111",
            "6D16",
            "6D5",
            "6D128",
            "6D71",
            "6D33",
            "6D127",
            "6D94",
            "6D54",
            "6D99",
            "6D36",
            "6D74",
            "6D38",
            "6D66",
            "6D108",
            "6D29",
            "6D131",
            "6D52",
            "6D119",
            "6D41",
            "6D6",
            "6D8",
            "6D48",
            "6D20",
            "6D50",
            "6D83",
            "6D118",
            "6D140",
            "6D12",
            "6D90",
            "6D14",
            "6D73",
            "6D80",
            "6D107",
            "6D134",
            "6D68",
            "6D100",
            "6D113",
            "6D117",
            "6D103",
            "6D105",
            "6D17",
            "6D130",
            "6D142",
            "6D21",
            "6D49",
            "6D86",
            "6D91",
            "6D112",
            "6D78",
            "6D93",
            "6D88",
            "6D46",
            "6D10",
            "6D27",
            "6D22",
            "6D47",
            "6D15",
            "6D145",
            "6D89",
            "6D70",
            "6D141",
            "6D35",
            "6D75",
            "6D124",
            "6D144",
            "6D122",
            "6D104",
            "6D92",
            "6D98",
            "6D96",
            "6D102",
            "6D120",
            "6D116",
            "6D129",
            "6D82",
            "6D45",
            "6D138",
            "6D77",
            "6D136",
            "6D37",
            "6D42",
            "6D53",
            "6D79",
            "6D44",
            "6D56",
            "6D57",
            "6D67",
            "6D64",
            "6D9",
            "6D13",
            "6D59"
    };

    private class FeatureMatching extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            //File dir = new File(strings[0]);
            try {
                featureMatching();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public void featureMatching() {
            //ArrayList<Patient> sourcePatients = db.getAll6WeekLeftEars();
            Gson gson = new Gson();
            ArrayList<ArrayList<Integer>> feature1, feature2, feature3, feature4, feature5, feature6, feature7, feature8, feature9, feature10;
            Double distance;
            //for(Patient patientSource : sourcePatients) {
            for(String filename : available) {
                Patient patientSource = db.get6WeekLeftPatient(filename);
                //feature1 = patientSource.getFeatures().get(0).getFeat();
                //feature2 = db.get14WeekLeft30Patient(filename).getFeatures().get(0).getFeat();
                //feature1.addAll(feature2);
                //patientSource.getFeatures().get(0).setFeatures(gson.toJson(feature1));
                target.add(patientSource);


                Patient p2 = db.get6DayLeftPatient(filename);
                /*feature3 = p2.getFeatures().get(0).getFeat();
                feature4 = db.get10WeekLeft30Patient(filename).getFeatures().get(0).getFeat();
                feature3.addAll(feature4);
                feature5 = db.get6WeekLeftPatient(filename).getFeatures().get(0).getFeat();
                feature6 = db.get6WeekLeft30Patient(filename).getFeatures().get(0).getFeat();
                feature3.addAll(feature5);
                feature3.addAll(feature6);
                feature7 = db.get6DayLeftPatient(filename).getFeatures().get(0).getFeat();
                feature8 = db.get6DayLeft30Patient(filename).getFeatures().get(0).getFeat();
                feature3.addAll(feature7);
                feature3.addAll(feature8);*/
                /*feature9 = db.get6DayLeftPatient(filename).getFeatures().get(0).getFeat();
                feature10 = db.get6DayLeft30Patient(filename).getFeatures().get(0).getFeat();
                feature3.addAll(feature9);
                feature3.addAll(feature10);*/
                //p2.getFeatures().get(0).setFeatures(gson.toJson(feature3));
                source.add(p2);
            }

            Log.d("Source size", Integer.toString(source.size()));
            Log.d("Target size", Integer.toString(target.size()));
            for(Patient patientSource : source) {
                for(Patient patientTarget : target) {
                    if(patientSource.getGender().equals(patientTarget.getGender())) {
                        db.addToScoreMatrix(patientSource, patientTarget, patientSource.getFeatures().get(0).distance(patientTarget.getFeatures().get(0)));
                    }
                }
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            p = new ProgressDialog(FullscreenActivity.this);
            p.setMessage("Feature matching is in progress...");
            p.setIndeterminate(false);
            p.setCancelable(false);
            p.show();
        }

        @Override
        protected void onPostExecute(String s) {
            p.hide();
            new Results().execute();
        }
    }

    private class Results extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            //File dir = new File(strings[0]);
            try {
                results();
            } catch (IOException e) {
                e.printStackTrace();
            }
            db.close();
            return null;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public void results() throws IOException {
            String baseDir = FullscreenActivity.pathname;
            String fileName = "/Results.csv";
            String filePath = baseDir + File.separator + fileName;
            FileWriter writer = new FileWriter(filePath);
                int count = 0, top1 = 0, top10 = 0;
                for(String filename : available) {
                    ArrayList<String> topTen = db.getTopTen(filename);
                    //if image is in topTen, add to top10
                    if (topTen.contains(filename)) {
                        top10++;
                        Log.d("Top ten", "Yes");
                        if (db.getTop(filename).equals(filename)) {
                            Log.d("Top one", "Yes");
                            top1++;
                        }
                    }
                    count++;
                }
                CSVUtils.writeLine(writer, Arrays.asList("Rank 1: " + (top1 / (double) count),
                        "Rank 10: " + (top10 / (double) count)), '|');

                Log.d("Rank-1", Double.toString(top1 / (double) count));
                Log.d("Rank-10", Double.toString(top10 / (double) count));
            writer.flush();
            writer.close();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            p = new ProgressDialog(FullscreenActivity.this);
            p.setMessage("Calculating Results...");
            p.setIndeterminate(false);
            p.setCancelable(false);
            p.show();
        }

        @Override
        protected void onPostExecute(String s) {
            p.hide();
            Toast.makeText(getApplicationContext(),"Results have been stored in Results.csv",Toast.LENGTH_LONG).show();
            db.close();
        }
    }
}
