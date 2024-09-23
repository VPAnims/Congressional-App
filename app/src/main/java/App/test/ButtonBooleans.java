package App.test;

public class ButtonBooleans {
    private Boolean FoodTrue;
    private Boolean ExerciseTrue;
    private Boolean ScreenTrue;
    private Boolean MeditatingTrue;
    private Boolean NoneTrue;

    public void setBooleanTrue(int num){
        FoodTrue = false;
        ScreenTrue= false;
        ExerciseTrue =false;
        NoneTrue = false;
        MeditatingTrue =false;

        if(num == 1){
            NoneTrue = true;
        }
        if(num == 2){
            FoodTrue = true;
        }
        if(num == 3){
            ScreenTrue = true;
        }
        if(num == 4){
            ExerciseTrue = true;
        }
        if(num == 5){
            MeditatingTrue = true;
        }
        if(num == 6){
            FoodTrue = false;
            ScreenTrue= false;
            ExerciseTrue =false;
            NoneTrue = false;
            MeditatingTrue =false;
        }
    }

}
