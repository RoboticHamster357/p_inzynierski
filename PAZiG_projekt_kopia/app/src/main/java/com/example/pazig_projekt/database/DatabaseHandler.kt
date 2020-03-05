package com.example.pazig_projekt.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.pazig_projekt.database.model.Diary
import com.example.pazig_projekt.dog.DogListActivity
import com.example.pazig_projekt.database.model.Dog
import com.example.pazig_projekt.dog.MyDogActivity
import com.example.pazig_projekt.food.FoodList
import com.example.pazig_projekt.food.ThisFoodActivity
import com.example.pazig_projekt.database.model.Food
import com.example.pazig_projekt.diary.DiaryActivity

class DatabaseHandler(context: Context) :SQLiteOpenHelper(context, DB_NAME,null, DB_VERSIOM) {

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_DIARY_TABLE="CREATE TABLE $DIARY_TABLE_NAME " +
                "($DIARY_ID INTEGER PRIMARY KEY, $DIARY_YEAR INT,$DIARY_MONTH INT,$DIARY_DAY INT ,$DIARY_DOG_NAME TEXT,$DIARY_FOOD_NAME TEXT,$DIARY_REACTION INT,$DIARY_DESCRIPTION TEXT)"
        db?.execSQL(CREATE_DIARY_TABLE)

        val CREATE_DOG_TABLE = "CREATE TABLE $TABLE_NAME " +
                "($ID INTEGER PRIMARY KEY, $NAME TEXT, $BODY_WEIGHT DOUBLE, $GENDER TEXT,  " +
                "$AGE INT, $AGE_UNIT TEXT, $OVERWEIGHT TEXT,$SLIMMING STRING, $PHYSICAL_ACTIVITY TEXT, $STERILIZATION STRING,$BREED TEXT)"

        db?.execSQL(CREATE_DOG_TABLE)

        val CREATE_FOOD_TABLE="CREATE TABLE $FOOD_TABLE_NAME " +
                "($FOOD_ID INTEGER PRIMARY KEY, $FOOD_NAME TEXT,$FOOD_CALORIFIC INT)"
        db?.execSQL(CREATE_FOOD_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun addDog(dog: Dog):Boolean{
        val db=this.writableDatabase
        val values=ContentValues()
        values.put(NAME,dog.name)
        values.put(BODY_WEIGHT,dog.bodyWeight)
        values.put(GENDER,dog.gender)
        values.put(AGE,dog.age)
        values.put(AGE_UNIT,dog.ageUnit)
        values.put(OVERWEIGHT,dog.overweight)
        values.put(SLIMMING,dog.slimming)
        values.put(PHYSICAL_ACTIVITY,dog.physicalActivity)
        values.put(BREED,dog.breed)
        values.put(STERILIZATION,dog.sterilization)
        val _success=db.insert(TABLE_NAME,null,values)
        db.close()
        Log.v("InsertedID","$_success")
        return (Integer.parseInt("$_success")!=-1)
    }
    fun addFood(food: Food):Boolean{
        val db=this.writableDatabase
        val values=ContentValues()
        values.put(FOOD_NAME,food.food_name)
        values.put(FOOD_CALORIFIC,food.food_calorific)
        val _success=db.insert(FOOD_TABLE_NAME,null,values)
        db.close()
        Log.v("InsertedID","$_success")
        return (Integer.parseInt("$_success")!=-1)
    }
    fun addDiary(diary: Diary):Boolean{
        val db=this.writableDatabase
        val values=ContentValues()
        values.put(DIARY_YEAR,diary.year)
        values.put(DIARY_MONTH,diary.month)
        values.put(DIARY_DAY,diary.day)
        values.put(DIARY_DOG_NAME,diary.dogName)
        values.put(DIARY_FOOD_NAME,diary.foodName)
        values.put(DIARY_REACTION,diary.dogReaction)
        values.put(DIARY_DESCRIPTION,diary.description)
        val _success=db.insert(DIARY_TABLE_NAME,null,values)
        db.close()
        Log.v("InsertedID","$_success")
        return (Integer.parseInt("$_success")!=-1)
    }
    fun getOneDog(my_dog_id: String): MyDogActivity.DogInformation {
        val db = this.writableDatabase
        val selectQuery = "SELECT  * FROM $TABLE_NAME WHERE $ID = $my_dog_id"
        val cursor = db.rawQuery(selectQuery, null)
        var name=""
        var bodyWeight=0.0
        var gender=""
        var age=0
        var ageUnit=""
        var overweight=""
        var slimming=""
        var physicalActivity=""
        var sterilization=""
        var breed=""
        var dog = MyDogActivity.DogInformation(my_dog_id,name,bodyWeight,gender,age,ageUnit,overweight,slimming,physicalActivity,sterilization,breed)

        if (cursor.getCount() > 0) {
            cursor.moveToFirst()
            name=cursor.getString(cursor.getColumnIndex(NAME))
            bodyWeight=cursor.getDouble(cursor.getColumnIndex(BODY_WEIGHT))
            gender=cursor.getString(cursor.getColumnIndex(GENDER))
            age=cursor.getInt(cursor.getColumnIndex(AGE))
            ageUnit=cursor.getString(cursor.getColumnIndex(AGE_UNIT))
            overweight=cursor.getString(cursor.getColumnIndex(OVERWEIGHT))
            slimming=cursor.getString(cursor.getColumnIndex(SLIMMING))
            physicalActivity=cursor.getString(cursor.getColumnIndex(PHYSICAL_ACTIVITY))
            sterilization=cursor.getString(cursor.getColumnIndex(STERILIZATION))
            dog= MyDogActivity.DogInformation(my_dog_id,name,bodyWeight,gender,age,ageUnit,overweight,slimming,physicalActivity,sterilization,breed)

        }
        cursor.close()
        return dog
    }

    fun getOneFood(foodID: String): ThisFoodActivity.FoodInformation {
        val db = this.writableDatabase
        val selectThisFoodQuery = "SELECT * FROM $FOOD_TABLE_NAME WHERE $ID = $foodID"
        val cursor=db.rawQuery(selectThisFoodQuery,null)
        var foodName=""
        var foodCalorific=0.0
        var food = ThisFoodActivity.FoodInformation(foodID,foodName,foodCalorific)

        if (cursor.count > 0) {
            cursor.moveToFirst()
            val foodName=cursor.getString(cursor.getColumnIndex(FOOD_NAME))
            val foodCalorific=cursor.getDouble(cursor.getColumnIndex(FOOD_CALORIFIC))
            food= ThisFoodActivity.FoodInformation(foodID,foodName,foodCalorific)

        }
        cursor.close()
        return food
    }
    fun getAllFood(): ArrayList<ThisFoodActivity.FoodInformation> {
        val list = ArrayList<ThisFoodActivity.FoodInformation>()
        val db = readableDatabase
        val selectAllDogQuery = "SELECT * FROM $FOOD_TABLE_NAME"
        val cursor = db.rawQuery(selectAllDogQuery, null)
        if (cursor != null) {
            if (cursor.count > 0) {
                cursor.moveToFirst()
                do {
                    val foodID = cursor.getString(cursor.getColumnIndex(FOOD_ID))
                    val foodName = cursor.getString(cursor.getColumnIndex(FOOD_NAME))
                    val foodCalorific=cursor.getDouble(cursor.getColumnIndex(FOOD_CALORIFIC))
                    val food = ThisFoodActivity.FoodInformation(foodID, foodName,foodCalorific)
                    list.add(food)
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        return list
    }
   fun getDogNames(): ArrayList<DogListActivity.DogName> {
           val list = ArrayList<DogListActivity.DogName>()
           val db=readableDatabase
           val selectAllDogQuery="SELECT * FROM $TABLE_NAME"
           val cursor=db.rawQuery(selectAllDogQuery,null)
           if (cursor != null) {
               if (cursor.count > 0) {
                   cursor.moveToFirst()
                   do {
                       val id = cursor.getString(cursor.getColumnIndex(ID))
                       val name = cursor.getString(cursor.getColumnIndex(NAME))
                       val dog = DogListActivity.DogName(id,name)
                       list.add(dog)
                   } while (cursor.moveToNext())
               }
           }
           cursor.close()
           return list
    }
    fun getFoodNames(): ArrayList<FoodList.FoodName> {
        val list = ArrayList<FoodList.FoodName>()
        val db=readableDatabase
        val selectAllFoodQuery="SELECT * FROM $FOOD_TABLE_NAME"
        val cursor=db.rawQuery(selectAllFoodQuery,null)
        if (cursor != null) {
            if (cursor.count > 0) {
                cursor.moveToFirst()
                do {
                    val id = cursor.getString(cursor.getColumnIndex(FOOD_ID))
                    val name = cursor.getString(cursor.getColumnIndex(FOOD_NAME))
                    val food = FoodList.FoodName(id,name)
                    list.add(food)
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        return list
    }
    fun getAllDiary(): ArrayList<DiaryActivity.DiaryInformation> {
        val list = ArrayList<DiaryActivity.DiaryInformation>()
        val db = readableDatabase
        val selectAllDiaryQuery = "SELECT * FROM $DIARY_TABLE_NAME"
        val cursor = db.rawQuery(selectAllDiaryQuery, null)
        if (cursor != null) {
            if (cursor.count > 0) {
                cursor.moveToFirst()
                do {
                    val diaryID = cursor.getString(cursor.getColumnIndex(DIARY_ID))
                    val yaer = cursor.getInt(cursor.getColumnIndex(DIARY_YEAR))
                    val month=cursor.getInt(cursor.getColumnIndex(DIARY_MONTH))
                    val day = cursor.getInt(cursor.getColumnIndex(DIARY_DAY))
                    val dogName=cursor.getString(cursor.getColumnIndex(DIARY_DOG_NAME))
                    val foodName=cursor.getString(cursor.getColumnIndex(DIARY_FOOD_NAME))
                    val dogReaction=cursor.getInt(cursor.getColumnIndex(DIARY_REACTION))
                    val description=cursor.getString(cursor.getColumnIndex(DIARY_DESCRIPTION))
                    val diary=DiaryActivity.DiaryInformation(diaryID,yaer,month,day,dogName,foodName,dogReaction,description)
                    list.add(diary)
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        return list
    }
    companion object {
        private val DB_NAME = "DogsDB"
        private val DB_VERSIOM = 10
        private val TABLE_NAME = "Dogs"
        private val ID = "Id"
        private val NAME = "FirstName"
        private var BODY_WEIGHT="BodyWeight"
        private var GENDER="Gender"
        private var AGE="Age"
        private var AGE_UNIT="AgeUnit"
        private var OVERWEIGHT="Overweight"
        private var SLIMMING="Slimming"
        private var PHYSICAL_ACTIVITY="PhysicalActivity"
        private var STERILIZATION="Sterilization"
        private var BREED="Breed"

        private var FOOD_TABLE_NAME="Food"
        private var FOOD_ID = "Id"
        private var FOOD_NAME = "Name"
        private var FOOD_CALORIFIC="Calorific"

        private var DIARY_TABLE_NAME="Diary"
        private var DIARY_ID="Id"
        private var DIARY_YEAR="Year"
        private var DIARY_MONTH="Month"
        private var DIARY_DAY="Day"
        private var DIARY_DOG_NAME="DogName"
        private var DIARY_FOOD_NAME="FoodName"
        private var DIARY_REACTION="DogReaction"
        private var DIARY_DESCRIPTION="Description"
    }

}