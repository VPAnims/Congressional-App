package App.test;

public class ButtonBooleans {
    private Boolean FoodTrue;
    private Boolean ExerciseTrue;
    private Boolean ScreenTrue;
    private Boolean MeditatingTrue;
    private Boolean NoneTrue;

    public void setBool(int num){
        if(num == 1){
            NoneTrue = true;
            FoodTrue = false;
            ScreenTrue = false;
            MeditatingTrue = false;
            ExerciseTrue = false;
        }
        if(num == 2){
            NoneTrue = false;
            FoodTrue = true;
            ScreenTrue = false;
            MeditatingTrue = false;
            ExerciseTrue = false;
        }
        if(num == 3){
            NoneTrue = false;
            FoodTrue = false;
            ScreenTrue = true;
            MeditatingTrue = false;
            ExerciseTrue = false;
        }
        if(num == 4){
            NoneTrue = false;
            FoodTrue = false;
            ScreenTrue = false;
            MeditatingTrue = true;
            ExerciseTrue = false;
        }
        if(num == 5){
            NoneTrue = false;
            FoodTrue = false;
            ScreenTrue = false;
            MeditatingTrue = false;
            ExerciseTrue = true;
        }
    }
    public boolean getScreenBool(){
        return ScreenTrue;
    }
    public boolean getFoodBool(){
        return FoodTrue;
    }

}
