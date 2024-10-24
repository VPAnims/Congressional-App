package App.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import App.test.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private CalendarView calandar;
    private ImageView DownArrow;
    private ImageView DownArrow2;
    private ImageView UpArrow;
    private ImageView FireImage;
    private ImageView FoodImage;
    private ImageView ExerciseImage;
    private ImageView ScreenImage;
    private ImageView MeditatingImage;
    private GridLayout linearLayout;
    private TextView AppName;
    private TextView tutorial1;
    private TextView tutorial2;
    private TextView tutorial3;
    private TextView tutorial4;
    private TextView invisText1;
    private TextView streakText;
    private TextView habitName;
    private Button addStreakButton;
    private ImageView HabitsButton;
    private Button NewHabitButton;
    private Spinner pickHabit;
    private Button FinishButton;
    private Boolean FoodTrue = false;
    private Boolean DeleteFood = false;
    private Boolean ExerciseTrue = false;
    private Boolean ScreenTrue = false;
    private Boolean MeditatingTrue = false;
    private Boolean NoneTrue = true;
    //private Typeface quicksand = ResourcesCompat.getFont(this, R.font.quicksand);
    private int colorNumber = 1;
    private static long two_minutes = TimeUnit.DAYS.toMillis(1);


    private static long four_minutes =TimeUnit.DAYS.toMillis(2);

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calandar = findViewById(R.id.calendarView2);
        calandar.setVisibility(View.VISIBLE);
        linearLayout = findViewById(R.id.layout);
        DownArrow = findViewById(R.id.down1);
        DownArrow2 = findViewById(R.id.down2);
        UpArrow = findViewById(R.id.uparrow);
        FireImage = findViewById(R.id.fire);
        FoodImage = findViewById(R.id.Food);
        ExerciseImage = findViewById(R.id.Exercise);
        ScreenImage = findViewById(R.id.screenTime);
        MeditatingImage = findViewById(R.id.Meditating);
        calandar = findViewById(R.id.thing);
        habitName = findViewById(R.id.habitName);
        tutorial1 = findViewById(R.id.textView);
        tutorial2 = findViewById(R.id.textView3);
        tutorial3 = findViewById(R.id.textView2);
        tutorial4 = findViewById(R.id.textView4);
        streakText = findViewById(R.id.streakText);
        invisText1 = findViewById(R.id.CreateText);
        AppName = findViewById(R.id.Name);
        addStreakButton = findViewById(R.id.addStreak);
        HabitsButton = findViewById(R.id.button);
        NewHabitButton = findViewById(R.id.NextPageButton);
        FinishButton = findViewById(R.id.finishAdding);
        pickHabit = findViewById(R.id.pickHabit);

        SharedPreferences foodPrefs = getSharedPreferences("foodHabit", MODE_PRIVATE);
        SharedPreferences screenPrefs = getSharedPreferences("screenHabit", MODE_PRIVATE);
        SharedPreferences meditatePrefs = getSharedPreferences("meditateHabit", MODE_PRIVATE);
        SharedPreferences exercisePrefs = getSharedPreferences("exerciseHabit", MODE_PRIVATE);

        SharedPreferences.Editor foodEditor = foodPrefs.edit();
        SharedPreferences.Editor screenEditor = screenPrefs.edit();
        SharedPreferences.Editor meditateEditor = meditatePrefs.edit();
        SharedPreferences.Editor exerciseEditor = exercisePrefs.edit();

        boolean isFoodTrue = foodPrefs.getBoolean("FoodTrue", false);
        boolean isScreenTrue = screenPrefs.getBoolean("ScreenTrue", false);
        boolean isMeditateTrue = meditatePrefs.getBoolean("MeditateTrue", false);
        boolean isExerciseTrue = exercisePrefs.getBoolean("ExerciseTrue", false);




        if(isFoodTrue == true){
            Button foodButton = new Button(this);
            foodButton.setText("      Eating Healthy      ");
            foodButton.setAllCaps(false);
            foodButton.setBackground(getResources().getDrawable(R.drawable.yellow_round_btn));
            Button deleteFood = new Button(this);
            deleteFood.setText("Delete");
            deleteFood.setAllCaps(false);
            deleteFood.setBackground(getResources().getDrawable(R.drawable.green_roundish));

            foodButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FoodTrue = true;
                    ExerciseTrue = false;
                    ScreenTrue = false;
                    MeditatingTrue = false;
                    calandar.setVisibility(v.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Eating Healthy", Toast.LENGTH_SHORT).show();
                    habitName.setText("Eating Healthy Everyday");
                    CreatedButtonClicked();
                }
            });
            deleteFood.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    linearLayout.removeView(foodButton);
                    linearLayout.removeView(deleteFood);
                    FoodTrue = false;
                    foodEditor.putBoolean("FoodTrue", FoodTrue);
                    foodEditor.putInt("foodStreak", 0);
                    foodEditor.putLong("lastFoodInteraction", 0);
                    foodEditor.apply();
                    Toast.makeText(getApplicationContext(), "Habit Deleted", Toast.LENGTH_SHORT).show();
                }
            });

            linearLayout.addView(foodButton);
            linearLayout.addView(deleteFood);
        }
        if(isScreenTrue == true){
            Button screenbutton = new Button(this);
            screenbutton.setText("  Limit Screen Time   ");
            screenbutton.setAllCaps(false);
            screenbutton.setBackground(getResources().getDrawable(R.drawable.yellow_round_btn));
            Button delete = new Button(this);
            delete.setText("Delete");
            delete.setAllCaps(false);
            delete.setBackground(getResources().getDrawable(R.drawable.green_roundish));

            screenbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FoodTrue = false;
                    ExerciseTrue = false;
                    ScreenTrue = true;
                    MeditatingTrue = false;
                    Toast.makeText(getApplicationContext(), "Limit Screen Time", Toast.LENGTH_SHORT).show();
                    habitName.setText("Limiting Screen Time Everyday");
                    CreatedButtonClicked();
                }
            });
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    linearLayout.removeView(screenbutton);
                    linearLayout.removeView(delete);
                    ScreenTrue = false;
                    screenEditor.putBoolean("ScreenTrue", ScreenTrue);
                    screenEditor.putInt("screenStreak", 0);
                    screenEditor.putLong("lastScreenInteraction", 0);
                    screenEditor.apply();
                    Toast.makeText(getApplicationContext(), "Habit Deleted", Toast.LENGTH_SHORT).show();
                }
            });

            linearLayout.addView(screenbutton);
            linearLayout.addView(delete);
        }
        if(isMeditateTrue == true){
            Button mbutton = new Button(this);
            mbutton.setText("          Meditating         ");
            mbutton.setAllCaps(false);
            mbutton.setBackground(getResources().getDrawable(R.drawable.yellow_round_btn));
            Button delete = new Button(this);
            delete.setText("Delete");
            delete.setAllCaps(false);
            delete.setBackground(getResources().getDrawable(R.drawable.green_roundish));

            mbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FoodTrue = false;
                    ExerciseTrue = false;
                    ScreenTrue = false;
                    MeditatingTrue = true;
                    Toast.makeText(getApplicationContext(), "Meditating Everyday", Toast.LENGTH_SHORT).show();
                    habitName.setText(" Meditating Everyday ");
                    CreatedButtonClicked();
                }
            });
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    linearLayout.removeView(mbutton);
                    linearLayout.removeView(delete);
                    MeditatingTrue = false;
                    meditateEditor.putBoolean("MeditateTrue", MeditatingTrue);
                    meditateEditor.putInt("meditateStreak", 0);
                    meditateEditor.putLong("lastMeditateInteraction", 0);
                    meditateEditor.apply();
                    Toast.makeText(getApplicationContext(), "Habit Deleted", Toast.LENGTH_SHORT).show();
                }
            });

            linearLayout.addView(mbutton);
            linearLayout.addView(delete);
        }
        if(isExerciseTrue == true){
            Button ebutton = new Button(this);
            ebutton.setText(" Exercising Everyday ");
            ebutton.setAllCaps(false);
            ebutton.setBackground(getResources().getDrawable(R.drawable.yellow_round_btn));
            Button delete = new Button(this);
            delete.setText("Delete");
            delete.setAllCaps(false);
            delete.setPadding(10, 10, 10, 10);
            delete.setBackground(getResources().getDrawable(R.drawable.green_roundish));

            ebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FoodTrue = false;
                    ExerciseTrue = true;
                    ScreenTrue = false;
                    MeditatingTrue = false;
                    Toast.makeText(getApplicationContext(), "Exercising Everyday", Toast.LENGTH_SHORT).show();
                    habitName.setText("Exercising Everyday");
                    CreatedButtonClicked();
                }
            });
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    linearLayout.removeView(ebutton);
                    linearLayout.removeView(delete);
                    ExerciseTrue = false;
                    exerciseEditor.putBoolean("ExerciseTrue", ExerciseTrue);
                    exerciseEditor.putInt("exerciseStreak", 0);
                    exerciseEditor.putLong("lastExerciseInteraction", 0);
                    exerciseEditor.apply();
                    Toast.makeText(getApplicationContext(), "Habit Deleted", Toast.LENGTH_SHORT).show();
                }
            });

            linearLayout.addView(ebutton);
            linearLayout.addView(delete);
        }

        pickHabit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();
                String Choice;
                Choice = item;
                if(Choice == "None"){
                    FinishButton.setVisibility(View.INVISIBLE);
                    MeditatingImage.setVisibility(View.INVISIBLE);
                    FoodImage.setVisibility(View.INVISIBLE);
                    ScreenImage.setVisibility(View.INVISIBLE);
                    ExerciseImage.setVisibility(View.INVISIBLE);
                    FoodTrue = false;
                    ExerciseTrue = false;
                    ScreenTrue = false;
                    MeditatingTrue = false;
                    NoneTrue = true;
                }
                else{
                    NoneTrue = false;
                    FinishButton.setVisibility(View.VISIBLE);
                }
                if(Choice == "Eating Healthy"){
                    MeditatingImage.setVisibility(View.INVISIBLE);
                    FoodImage.setVisibility(View.VISIBLE);
                    ScreenImage.setVisibility(View.INVISIBLE);
                    ExerciseImage.setVisibility(View.INVISIBLE);
                    FoodTrue = true;
                    ExerciseTrue = false;
                    ScreenTrue = false;
                    MeditatingTrue = false;
                }
                if(Choice == "Exercising Everyday"){
                    MeditatingImage.setVisibility(View.INVISIBLE);
                    FoodImage.setVisibility(View.INVISIBLE);
                    ScreenImage.setVisibility(View.INVISIBLE);
                    ExerciseImage.setVisibility(View.VISIBLE);
                    FoodTrue = false;
                    ExerciseTrue = true;
                    ScreenTrue = false;
                    MeditatingTrue = false;
                }
                if(Choice == "Meditating"){
                    MeditatingImage.setVisibility(View.VISIBLE);
                    FoodImage.setVisibility(View.INVISIBLE);
                    ScreenImage.setVisibility(View.INVISIBLE);
                    ExerciseImage.setVisibility(View.INVISIBLE);
                    FoodTrue = false;
                    ExerciseTrue = false;
                    ScreenTrue = false;
                    MeditatingTrue = true;
                }
                if(Choice == "Limiting Screen Time"){
                    MeditatingImage.setVisibility(View.INVISIBLE);
                    FoodImage.setVisibility(View.INVISIBLE);
                    ScreenImage.setVisibility(View.VISIBLE);
                    ExerciseImage.setVisibility(View.INVISIBLE);
                    FoodTrue = false;
                    ExerciseTrue = false;
                    ScreenTrue = true;
                    MeditatingTrue = false;
                }

                //Toast.makeText(MainActivity.this, "Selected: " + item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                FinishButton.setVisibility(View.INVISIBLE);
            }
        });
        ArrayList<String> habits = new ArrayList<>();
        habits.add("None");
        habits.add("Eating Healthy");
        habits.add("Exercising Everyday");
        habits.add("Meditating");
        habits.add("Limiting Screen Time");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, habits);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        pickHabit.setAdapter(adapter);
    }

    public void NextPage(View view){
        linearLayout.setVisibility(View.INVISIBLE);
        invisText1.setVisibility(View.VISIBLE);
        HabitsButton.setVisibility(View.INVISIBLE);
        AppName.setVisibility(View.INVISIBLE);
        pickHabit.setVisibility(View.VISIBLE);
        NewHabitButton.setVisibility(View.GONE);
        tutorial1.setVisibility(View.INVISIBLE);
        DownArrow.setVisibility(View.INVISIBLE);
        tutorial2.setVisibility(View.VISIBLE);
        UpArrow.setVisibility(View.VISIBLE);
    }

    public void addStreak(View view){
        habitName.setVisibility(View.VISIBLE);
        FireImage.setVisibility(View.VISIBLE);
        streakText.setVisibility(View.VISIBLE);
        habitName.setVisibility(View.VISIBLE);
        addStreakButton.setVisibility(View.INVISIBLE);
        calandar.setVisibility(View.VISIBLE);
        tutorial3.setVisibility(View.VISIBLE);
        tutorial4.setVisibility(View.INVISIBLE);
        android.view.ViewGroup.LayoutParams params = calandar.getLayoutParams();
        params.width = 1000;
        params.height = 1000;
        calandar.setLayoutParams(params);
        calandar.requestLayout();

        long currentTime = System.currentTimeMillis();

        SharedPreferences screenPreferences = getSharedPreferences("screenHabit", MODE_PRIVATE);
        SharedPreferences foodPreferences = getSharedPreferences("foodHabit", MODE_PRIVATE);
        SharedPreferences meditatingPreferences = getSharedPreferences("meditateHabit", MODE_PRIVATE);
        SharedPreferences exercisePreferences = getSharedPreferences("exerciseHabit", MODE_PRIVATE);

        SharedPreferences.Editor foodEditor = foodPreferences.edit();
        SharedPreferences.Editor screenEditor = screenPreferences.edit();
        SharedPreferences.Editor meditateEditor = meditatingPreferences.edit();
        SharedPreferences.Editor exerciseEditor = exercisePreferences.edit();

        if(FoodTrue == true){
            habitName.setText("Eating Healthy Everyday");

            int currentFoodStreak = foodPreferences.getInt("foodStreak", 0);
            streakText.setText("Current Streak: " + currentFoodStreak);
            long lastFoodInteraction = foodPreferences.getLong("lastFoodInteraction", 0);

            if(lastFoodInteraction == 0) {
                currentFoodStreak = 1;
            }else{
                long timeDiff = currentTime - lastFoodInteraction;

                if(timeDiff >= two_minutes && timeDiff < four_minutes){
                    currentFoodStreak++;
                } else if(timeDiff > four_minutes){
                    currentFoodStreak = 1;
                }
            }
            foodEditor.putLong("lastFoodInteraction", currentTime);
            foodEditor.putInt("foodStreak", currentFoodStreak);
            foodEditor.apply();

            streakText.setText("Current Streak: " + currentFoodStreak);
        }
        else if(ScreenTrue == true){
            habitName.setText("Limiting Screen Time");

            int currentScreenStreak = screenPreferences.getInt("screenStreak", 0);
            streakText.setText("Current Streak: " + currentScreenStreak);
            long lastScreenInteraction = screenPreferences.getLong("lastScreenInteraction", 0);

            if(lastScreenInteraction == 0) {
                currentScreenStreak = 1;
            }
            else{
                long timeDiff = currentTime- lastScreenInteraction;

                if(timeDiff >= two_minutes && timeDiff < four_minutes){
                    currentScreenStreak++;
                } else if (timeDiff > four_minutes) {
                    currentScreenStreak = 1;
                }
            }
            screenEditor.putLong("lastScreenInteraction", currentTime);
            screenEditor.putInt("screenStreak", currentScreenStreak);

            screenEditor.apply();
            streakText.setText("Current Streak: " + currentScreenStreak);
        }
        else if (MeditatingTrue == true) {
            habitName.setText("Meditating Everyday");

            int currentMeditateStreak = meditatingPreferences.getInt("meditateStreak", 0);
            streakText.setText("Current Streak: " + currentMeditateStreak);
            long lastMeditateInteraction = meditatingPreferences.getLong("lastMeditateInteraction", 0);

            if(lastMeditateInteraction == 0) {
                currentMeditateStreak = 1;
            }
            else{
                long timeDiff = currentTime- lastMeditateInteraction;

                if(timeDiff >= two_minutes && timeDiff < four_minutes){
                    currentMeditateStreak++;
                } else if (timeDiff > four_minutes) {
                    currentMeditateStreak = 1;
                }
            }
            meditateEditor.putLong("lastMeditateInteraction", currentTime);
            meditateEditor.putInt("screenStreak", currentMeditateStreak);
            meditateEditor.apply();
            streakText.setText("Current Streak: " + currentMeditateStreak);
        }
        else if (ExerciseTrue == true) {
            habitName.setText("Exercising Everyday");

            int currentExerciseStreak = exercisePreferences.getInt("exerciseStreak", 0);
            streakText.setText("Current Streak: " + currentExerciseStreak);
            long lastExerciseInteraction = exercisePreferences.getLong("lastExerciseInteraction", 0);

            if(lastExerciseInteraction == 0) {
                currentExerciseStreak = 1;
            }
            else{
                long timeDiff = currentTime - lastExerciseInteraction;

                if(timeDiff >= two_minutes && timeDiff < four_minutes){
                    currentExerciseStreak++;
                } else if(timeDiff > four_minutes){
                    currentExerciseStreak = 1;
                }
            }
            exerciseEditor.putLong("lastExerciseInteraction", currentTime);
            exerciseEditor.putInt("exerciseStreak", currentExerciseStreak);
            exerciseEditor.apply();
            streakText.setText("Current Streak: " + currentExerciseStreak);
        }

    }

    public void CreatedButtonClicked() {
        addStreakButton.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.INVISIBLE);
        invisText1.setVisibility(View.INVISIBLE);
        HabitsButton.setVisibility(View.INVISIBLE);
        AppName.setVisibility(View.INVISIBLE);
        pickHabit.setVisibility(View.INVISIBLE);
        NewHabitButton.setVisibility(View.INVISIBLE);
        FinishButton.setVisibility(View.INVISIBLE);
        MeditatingImage.setVisibility(View.INVISIBLE);
        FoodImage.setVisibility(View.INVISIBLE);
        ScreenImage.setVisibility(View.INVISIBLE);
        ExerciseImage.setVisibility(View.INVISIBLE);
        tutorial4.setVisibility(View.INVISIBLE);
        tutorial1.setVisibility(View.INVISIBLE);
        DownArrow.setVisibility(View.INVISIBLE);
    }

    public void PreviousPage(View view){

        FireImage.setVisibility(View.INVISIBLE);
        streakText.setVisibility(View.INVISIBLE);
        habitName.setVisibility(View.INVISIBLE);
        addStreakButton.setVisibility(View.INVISIBLE);
        linearLayout.setVisibility(View.VISIBLE);
        invisText1.setVisibility(View.INVISIBLE);
        HabitsButton.setVisibility(View.VISIBLE);
        AppName.setVisibility(View.VISIBLE);

        pickHabit.setVisibility(View.INVISIBLE);
        NewHabitButton.setVisibility(View.VISIBLE);
        FinishButton.setVisibility(View.INVISIBLE);
        MeditatingImage.setVisibility(View.INVISIBLE);
        FoodImage.setVisibility(View.INVISIBLE);
        ScreenImage.setVisibility(View.INVISIBLE);
        ExerciseImage.setVisibility(View.INVISIBLE);
        tutorial3.setVisibility(View.INVISIBLE);
        tutorial2.setVisibility(View.INVISIBLE);
        UpArrow.setVisibility(View.INVISIBLE);

    }

    public void CreateHabit(View view){
        SharedPreferences foodPref = getSharedPreferences("foodHabit",MODE_PRIVATE);
        SharedPreferences screenPref = getSharedPreferences("screenHabit", MODE_PRIVATE);
        SharedPreferences meditatePref = getSharedPreferences("meditateHabit", MODE_PRIVATE);
        SharedPreferences exercisePref = getSharedPreferences("exerciseHabit", MODE_PRIVATE);

        SharedPreferences.Editor screenEditor = screenPref.edit();
        SharedPreferences.Editor foodEditor = foodPref.edit();
        SharedPreferences.Editor meditateEditor = meditatePref.edit();
        SharedPreferences.Editor exerciseEditor = exercisePref.edit();

        linearLayout.setVisibility(View.VISIBLE);
        if (FoodTrue == true) {
            colorNumber += 1;
            Button foodButton = new Button(this);
            foodButton.setText("      Eating Healthy      ");
            foodButton.setAllCaps(false);
            Button deleteFoodButton = new Button(this);
            deleteFoodButton.setAllCaps(false);
            deleteFoodButton.setText("Delete");

            foodEditor.putBoolean("FoodTrue", FoodTrue);
            foodEditor.apply();
            foodButton.setBackground(getResources().getDrawable(R.drawable.yellow_round_btn));
            deleteFoodButton.setBackground(getResources().getDrawable(R.drawable.green_roundish));

            foodButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FoodTrue = true;
                    ExerciseTrue = false;
                    ScreenTrue = false;
                    MeditatingTrue = false;
                    calandar.setVisibility(v.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Eating Healthy", Toast.LENGTH_SHORT).show();
                    habitName.setText("Eating Healthy Everyday");
                    CreatedButtonClicked();
                }
            });
            deleteFoodButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    linearLayout.removeView(foodButton);
                    linearLayout.removeView(deleteFoodButton);
                    FoodTrue = false;
                    foodEditor.putBoolean("FoodTrue", FoodTrue);
                    foodEditor.putInt("foodStreak", 0);
                    foodEditor.putLong("lastFoodInteraction", 0);
                    foodEditor.apply();
                    Toast.makeText(getApplicationContext(), "Habit Deleted", Toast.LENGTH_SHORT).show();
                }
            });

            linearLayout.addView(foodButton);
            linearLayout.addView(deleteFoodButton);
        }
        else if(ScreenTrue == true){
            colorNumber+=1;
            Button screenbutton = new Button(this);
            screenbutton.setText("  Limit Screen Time   ");
            screenbutton.setAllCaps(false);
            Button delete = new Button(this);
            delete.setText("Delete");
            delete.setAllCaps(false);

            screenEditor.putBoolean("ScreenTrue", ScreenTrue);
            screenEditor.apply();

            screenbutton.setBackground(getResources().getDrawable(R.drawable.yellow_round_btn));
            delete.setBackground(getResources().getDrawable(R.drawable.green_roundish));

            screenbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FoodTrue = false;
                    ExerciseTrue = false;
                    ScreenTrue = true;
                    MeditatingTrue = false;
                    Toast.makeText(getApplicationContext(), "Limit Screen Time", Toast.LENGTH_SHORT).show();
                    habitName.setText("Limiting Screen Time Everyday");
                    CreatedButtonClicked();
                }
            });
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    linearLayout.removeView(screenbutton);
                    linearLayout.removeView(delete);
                    ScreenTrue = false;
                    screenEditor.putBoolean("ScreenTrue", ScreenTrue);
                    screenEditor.putInt("screenStreak", 0);
                    screenEditor.putLong("lastScreenInteraction", 0);
                    screenEditor.apply();
                    Toast.makeText(getApplicationContext(), "Habit Deleted", Toast.LENGTH_SHORT).show();
                }
            });

            linearLayout.addView(screenbutton);
            linearLayout.addView(delete);
        }
        else if(MeditatingTrue == true){
            colorNumber +=1;
            Button mbutton = new Button(this);
            mbutton.setText("          Meditating         ");
            mbutton.setAllCaps(false);
            Button delete = new Button(this);
            delete.setText("Delete");
            delete.setAllCaps(false);

            meditateEditor.putBoolean("MeditateTrue", MeditatingTrue);
            meditateEditor.apply();

            mbutton.setBackground(getResources().getDrawable(R.drawable.yellow_round_btn));
            delete.setBackground(getResources().getDrawable(R.drawable.green_roundish));

            if(colorNumber%2 == 0){
                mbutton.setBackgroundColor(Color.parseColor("#FFC105"));
                meditateEditor.putInt("color", Color.parseColor("#FFC105"));
                delete.setBackgroundColor(Color.parseColor("#3DDC84"));
                meditateEditor.putInt("deleteColor", Color.parseColor("#3DDC84"));
                meditateEditor.apply();
            }else{
                mbutton.setBackgroundColor(Color.parseColor("#3DDC84"));
                meditateEditor.putInt("color", Color.parseColor("#3DDC84"));
                delete.setBackgroundColor(Color.parseColor("#FFC105"));
                meditateEditor.putInt("deleteColor", Color.parseColor("#FFC105"));
                meditateEditor.apply();
            }
            mbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FoodTrue = false;
                    ExerciseTrue = false;
                    ScreenTrue = false;
                    MeditatingTrue = true;
                    Toast.makeText(getApplicationContext(), "Meditating Everyday", Toast.LENGTH_SHORT).show();
                    habitName.setText(" Meditating Everyday ");
                    CreatedButtonClicked();
                }
            });
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    linearLayout.removeView(mbutton);
                    linearLayout.removeView(delete);
                    MeditatingTrue = false;
                    meditateEditor.putBoolean("MeditateTrue", MeditatingTrue);
                    meditateEditor.putInt("meditateStreak", 0);
                    meditateEditor.putLong("lastMeditateInteraction", 0);
                    meditateEditor.apply();
                    Toast.makeText(getApplicationContext(), "Habit Deleted", Toast.LENGTH_SHORT).show();
                }
            });

            linearLayout.addView(mbutton);
            linearLayout.addView(delete);
        }
        else if(ExerciseTrue == true){
            colorNumber +=1;
            Button ebutton = new Button(this);
            ebutton.setText(" Exercising Everyday ");
            ebutton.setAllCaps(false);
            Button delete = new Button(this);
            delete.setText("Delete");
            delete.setAllCaps(false);

            exerciseEditor.putBoolean("ExerciseTrue", ExerciseTrue);
            exerciseEditor.apply();

            ebutton.setBackground(getResources().getDrawable(R.drawable.yellow_round_btn));
            delete.setBackground(getResources().getDrawable(R.drawable.green_roundish));
            if(colorNumber%2 == 0){
                ebutton.setBackgroundColor(Color.parseColor("#FFC105"));
                exerciseEditor.putInt("color", Color.parseColor("#FFC105"));
                delete.setBackgroundColor(Color.parseColor("#3DDC84"));
                exerciseEditor.putInt("deleteColor", Color.parseColor("#3DDC84"));
                exerciseEditor.apply();
            }else{
                ebutton.setBackgroundColor(Color.parseColor("#3DDC84"));
                exerciseEditor.putInt("color", Color.parseColor("#3DDC84"));
                delete.setBackgroundColor(Color.parseColor("#FFC105"));
                exerciseEditor.putInt("deleteColor", Color.parseColor("#FFC105"));
                exerciseEditor.apply();
            }
            ebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FoodTrue = false;
                    ExerciseTrue = true;
                    ScreenTrue = false;
                    MeditatingTrue = false;
                    Toast.makeText(getApplicationContext(), "Exercising Everyday", Toast.LENGTH_SHORT).show();
                    habitName.setText("Exercising Everyday");
                    CreatedButtonClicked();
                }
            });
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    linearLayout.removeView(ebutton);
                    linearLayout.removeView(delete);
                    ExerciseTrue = false;
                    exerciseEditor.putBoolean("ExerciseTrue", ExerciseTrue);
                    exerciseEditor.putInt("exerciseStreak", 0);
                    exerciseEditor.putLong("lastExerciseInteraction", 0);
                    exerciseEditor.apply();
                    Toast.makeText(getApplicationContext(), "Habit Deleted", Toast.LENGTH_SHORT).show();
                }
            });

            linearLayout.addView(ebutton);
            linearLayout.addView(delete);
        }

        invisText1.setVisibility(View.INVISIBLE);
        HabitsButton.setVisibility(View.VISIBLE);
        AppName.setVisibility(View.VISIBLE);

        pickHabit.setVisibility(View.INVISIBLE);
        NewHabitButton.setVisibility(View.VISIBLE);
        FinishButton.setVisibility(View.INVISIBLE);
        MeditatingImage.setVisibility(View.INVISIBLE);
        FoodImage.setVisibility(View.INVISIBLE);
        ScreenImage.setVisibility(View.INVISIBLE);
        ExerciseImage.setVisibility(View.INVISIBLE);
        tutorial4.setVisibility(View.VISIBLE);
        tutorial2.setVisibility(View.INVISIBLE);
        UpArrow.setVisibility(View.INVISIBLE);
    }

}


