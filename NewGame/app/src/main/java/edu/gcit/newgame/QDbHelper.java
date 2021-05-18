package edu.gcit.newgame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import edu.gcit.newgame.QContract.*;

import java.util.ArrayList;
import java.util.Locale;

public class QDbHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "MyDatabase.db";
    private static final int DATBASE_VERSION = 19;

    private SQLiteDatabase db;


    QDbHelper(Context context) {
        super(context, DATABASE_NAME,null, DATBASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionTable.COLUMN_ANSWER_NR + " TEXT, " +
                QuestionTable.COLUMN_CATEGORY + " TEXT, " +
                QuestionTable.COLUMN_SUBCATEGORY + " TEXT, " +
                QuestionTable.COLUMN_LEVELS_ID + " INTEGER " +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);

    }


    private void fillQuestionsTable()
    {
        //DRAG_AND_DROP
        //dd_level1
        Question dd11 = new Question("གླངམོ་ཆེ།","གླངམོ་ཆེ།","མ་ཧེ།","རི་གླང་།",null,"button1"
                ,Question.CATEGORY_ONE,null,1);
        addQuestions(dd11);

        Question dd12 = new Question("སྒོ་སྒྲིག།","སྒོ།","སྒོ་སྒྲིག།","ཀཝ།",null,"button2"
                ,Question.CATEGORY_ONE,null, 1);
        addQuestions(dd12);

        Question dd13 = new Question("ཨེ་པཱལ།","ཚལ་ལུ།","སེ་འགྲུ།","ཨེ་པཱལ།",null,"button3"
                ,Question.CATEGORY_ONE,null,1);
        addQuestions(dd13);
        Question dd14 = new Question("ས་རྒ།","ས་རྒ།","སྒོགཔ།","འོད་སི།",null,"button1"
                ,Question.CATEGORY_ONE,null,1);
        addQuestions(dd14);
        Question dd15 = new Question("ཅོག་རིལ།","དམག་རྩད།","ཅོག་རིལ།","འདེད་རིལ།",null,"button2"
                ,Question.CATEGORY_ONE,null,1);
        addQuestions(dd15);
        Question dd16 = new Question("འཛིནམ།","གཅུས་གཟེར་སྒྱིར་ཆས།","འཇལ་ཐག།","འཛིནམ།",null,"button3"
                ,Question.CATEGORY_ONE,null,1);
        addQuestions(dd16);

        //dd_level2
        Question dd21 = new Question("བྱམོ།","བྱམོ།","གླང་།","གཡག།",null,"button1"
                ,Question.CATEGORY_ONE,null,2);
        addQuestions(dd21);
        Question dd22 = new Question("གནམ་གྲུ་འབུཔ།","བྱ།","གནམ་གྲུ་འབུཔ།","གསེར་སྦྱང་།",null,"button2"
                ,Question.CATEGORY_ONE,null,2);
        addQuestions(dd22);
        Question dd23 = new Question("སྐུ།","མཤོད་བཆམ།","སྐུ་ཐང་།","སྐུ།",null,"button3"
                ,Question.CATEGORY_ONE,null,2);
        addQuestions(dd23);
        Question dd24 = new Question("པར་ཆས།","པར་ཆས།","པར་འཕྲུལ།","སྐད་འཕྲུལ།",null,"button1"
                ,Question.CATEGORY_ONE,null,2);
        addQuestions(dd24);
        Question dd25 = new Question("རྐངམ།","ལགཔ།","རྐངམ།","ཕོཝ།",null,"button2"
                ,Question.CATEGORY_ONE,null,2);
        addQuestions(dd25);
        Question dd26 = new Question("རུས་སྦལ།","སྲམ།","མཚོ་བྱ།","རུས་སྦལ།",null,"button3"
                ,Question.CATEGORY_ONE,null,2);
        addQuestions(dd26);

        //dd_level3
        Question dd31 = new Question("ཉལ་ཁྲི།","ཉལ་ཁྲི།","སྒྲོམ།","ལྡེ་མིག།",null,"button1"
                ,Question.CATEGORY_ONE,null,3);
        addQuestions(dd31);
        Question dd32 = new Question("ཟླ་པ།","པ་ལང་།","ཟླ་པ།","ཇམ་སྦྱིས།",null,"button2"
                ,Question.CATEGORY_ONE,null,3);
        addQuestions(dd32);
        Question dd33 = new Question("ཀྲོབ་མདའ།","ལག་བམ།","དགྲ་ལི།","ཀྲོབ་མདའ།",null,"button3"
                ,Question.CATEGORY_ONE,null,3);
        addQuestions(dd33);
        Question dd34 = new Question("དམརཔོ།","དམརཔོ།","སྐྱ་ཐལ།","གནགཔོ།",null,"button1"
                ,Question.CATEGORY_ONE,null,3);
        addQuestions(dd34);
        Question dd35 = new Question("ཨམ་ཅུ་ཀུ་ལི།","རྒུན་འབྲུམ།","ཨམ་ཅུ་ཀུ་ལི།","ཁམ།",null,"button2"
                ,Question.CATEGORY_ONE,null,3);
        addQuestions(dd35);
        Question dd36 = new Question("ཤ་མུ།","ནགས་སྐྱེས།","པ་ཚང་།","ཤ་མུ།",null,"button3"
                ,Question.CATEGORY_ONE,null,3);
        addQuestions(dd36);

        //dd_level4
        Question dd41 = new Question("མེ།","མེ།","ས།","ཆུ།",null,"button1"
                ,Question.CATEGORY_ONE,null,4);
        addQuestions(dd41);
        Question dd42 = new Question("གདུང་དཀར།","གདུགས།","གདུང་དཀར།","རྒྱལ་མཚན།",null,"button2"
                ,Question.CATEGORY_ONE,null,4);
        addQuestions(dd42);
        Question dd43 = new Question("མིག་ཏོ","རྣམ་ཅོ","ཁ","མིག་ཏོ",null,"button3"
                ,Question.CATEGORY_ONE,null,4);
        addQuestions(dd43);
        Question dd44 = new Question("སྟག་ཚེར་མེ་ཏོག","སྟག་ཚེར་མེ་ཏོག","ཉིམ་གང་ཤར་མེ་ཏོག","དྲིལ་བུ་མེ་ཏོག",null,"button1"
                ,Question.CATEGORY_ONE,null,4);
        addQuestions(dd44);
        Question dd45 = new Question("སེང་གེ","གཟིག","སེང་གེ","སྟག",null,"button2"
                ,Question.CATEGORY_ONE,null,4);
        addQuestions(dd45);
        Question dd46 = new Question("དྲུང་འཚོ","སློབ་དཔོན","ཚོང་པ","དྲུང་འཚོ",null,"button3"
                ,Question.CATEGORY_ONE,null,4);
        addQuestions(dd46);

        //Category_2
        //addition
        //add_level1
        Question a11 = new Question("༡+༣","༣","༤","༥","༦","༤"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE,1);
        addQuestions(a11);

        Question a12 = new Question("༢+༥","༥","༨","༧","༤","༧"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE, 1);
        addQuestions(a12);

        Question a13 = new Question("༨+༧","༡༣","༡༦","༡༤","༡༥","༡༥"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE,1);
        addQuestions(a13);
        Question a14 = new Question("༦+༦","༡༠","༡༢","༡༤","༡༡","༡༢"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE,1);
        addQuestions(a14);
        Question a15 = new Question("༡+༩","༩","༡༡","༡༠","༡༥","༡༠"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE,1);
        addQuestions(a15);
        Question a16 = new Question("༤+༤","༨","༦","༩","༡༠","༨"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE,1);
        addQuestions(a16);

        //add_level2
        Question a21 = new Question("༣+༡༦","༡༥","༢༠","༢༥","༡༩","༡༩"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE,2);
        addQuestions(a21);

        Question a22 = new Question("༡༣+༣","༡༦","༡༥","༡༧","༡༩","༡༦"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE, 2);
        addQuestions(a22);

        Question a23 = new Question("༡༠+༡༠","༢༡","༢༥","༢༠","༢༣","༢༠"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE,2);
        addQuestions(a23);
        Question a24 = new Question("༧+༧","༡༦","༡༤","༡༧","༡༨","༡༤"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE,2);
        addQuestions(a24);
        Question a25 = new Question("༡༥+༩","༢༣","༢༦","༢༤","༢༩","༢༤"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE,2);
        addQuestions(a25);
        Question a26 = new Question("༡༡+༡༤","༢༧","༢༨","༢༦","༢༣","༢༦"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE,2);
        addQuestions(a26);

        //add_level3
        Question a31 = new Question("༩+༢༣","༢༩","༣༢","༣༠","༣༣","༣༢"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE,3);
        addQuestions(a31);

        Question a32 = new Question("༡༡+༡༢","༢༤","༢༥","༢༣","༢༡","༢༣"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE, 3);
        addQuestions(a32);

        Question a33 = new Question("༡༢+༡༧","༣༠","༢༨","༣༡","༢༩","༢༩"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE,3);
        addQuestions(a33);
        Question a34 = new Question("༡༧+༢༡","༤༠","༤༡","༣༨","༣༩","༣༨"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE,3);
        addQuestions(a34);
        Question a35 = new Question("༢༡+༡༥","༣༦","༣༢","༣༧","༢༨","༣༦"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE,3);
        addQuestions(a35);
        Question a36 = new Question("༡༨+༡༢","༣༡","༣༢","༣༣","༣༠","༣༠"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE,3);
        addQuestions(a36);

        //add_level4
        Question a41 = new Question("༡༢+༡༣","༢༧","༢༥","༢༨","༢༣","༢༥"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE,4);
        addQuestions(a41);

        Question a42 = new Question("༡༩+༢༢","༤༡","༤༠","༤༢","༣༩","༤༡"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE, 4);
        addQuestions(a42);

        Question a43 = new Question("༢༡+༡༠","༣༣","༣༢","༣༠","༣༡","༣༡"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE,4);
        addQuestions(a43);
        Question a44 = new Question("༢༦+༡༩","༤༡","༤༣","༤༥","༤༤","༤༥"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE,4);
        addQuestions(a44);
        Question a45 = new Question("༢༥+༢༥","༥༡","༥༠","༥༢","༥༤","༥༠"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE,4);
        addQuestions(a45);
        Question a46 = new Question("༢༥+༢༠","༤༥","༤༦","༤༤","༤༧","༤༥"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_ONE,4);
        addQuestions(a46);

        //subtraction
        //sub_level1
        Question sa11 = new Question("༡-༡","༠","༢","༡","༣","༠"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO,1);
        addQuestions(sa11);

        Question sa12 = new Question("༤-༣","༣","༡","༢","༤","༡"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO, 1);
        addQuestions(sa12);

        Question sa13 = new Question("༥-༢","༢","༤","༣","༥","༣"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO,1);
        addQuestions(sa13);
        Question sa14 = new Question("༨-༤","༣","༥","༢","༤","༤"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO,1);
        addQuestions(sa14);
        Question sa15 = new Question("༧-༥","༢","༥","༣","༧","༢"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO,1);
        addQuestions(sa15);
        Question sa16 = new Question("༩-༤","༦","༥","༧","༣","༥"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO,1);
        addQuestions(sa16);

        //sub_level2
        Question sa21 = new Question("༡༠-༣","༧","༩","༨","༦","༧"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO,2);
        addQuestions(sa21);

        Question sa22 = new Question("༡༢-༢","༡༢","༡༠","༡༡","༡༣","༡༠"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO, 2);
        addQuestions(sa22);

        Question sa23 = new Question("༡༣-༡༣","༡༣","༡","༠","༢༦","༠"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO,2);
        addQuestions(sa23);
        Question sa24 = new Question("༡༤-༦","༦","༩","༧","༨","༨"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO,2);
        addQuestions(sa24);
        Question sa25 = new Question("༡༧-༡༡","༦","༧","༥","༤","༦"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO,2);
        addQuestions(sa25);
        Question sa26 = new Question("༡༥-༡༤","༣","༡","༢","༠","༡"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO,2);
        addQuestions(sa26);


        //sub_level3
        Question sa31 = new Question("༢༠-༡༣","༧","༦","༩","༨","༧"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO,3);
        addQuestions(sa31);

        Question sa32 = new Question("༢༣-༡༡","༡༡","༡༢","༡༣","༡༠","༡༢"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO, 3);
        addQuestions(sa32);

        Question sa33 = new Question("༢༥-༦","༢༠","༡༧","༡༩","༡༨","༡༩"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO,3);
        addQuestions(sa33);
        Question sa34 = new Question("༢༧-༢༡","༨","༩","༧","༨","༦"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO,3);
        addQuestions(sa34);
        Question sa35 = new Question("༢༡-༡༡","༡༠","༡༢","༡༡","༩","༡༠"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO,3);
        addQuestions(sa35);
        Question sa36 = new Question("༢༩-༡༢","༡༦","༡༧","༡༩","༡༨","༡༧"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO,3);
        addQuestions(sa36);

        //sub_level4
        Question sa41 = new Question("༣༡-༢༧","༤","༥","༣","༦","༤"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO,4);
        addQuestions(sa41);

        Question sa42 = new Question("༣༤-༡༧","༡༨","༡༧","༡༩","༡༦","༡༧"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO, 4);
        addQuestions(sa42);

        Question sa43 = new Question("༤༠-༡༠","༣༡","༣༢","༣༠","༣༢","༣༠"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO,4);
        addQuestions(sa43);
        Question sa44 = new Question("༣༩-༢༤","༡༧","༡༤","༡༦","༡༥","༡༥"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO,4);
        addQuestions(sa44);
        Question sa45 = new Question("༤༡-༣༢","༩","༡༡","༡༠","༡༢","༩"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO,4);
        addQuestions(sa45);
        Question sa46 = new Question("༤༣-༢༡","༢༠","༢༢","༢༡","༢༣","༢༢"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_TWO,4);
        addQuestions(sa46);

        //MULTIPLICATION
        //mul_level1
        Question m11 = new Question("༡x༣","༣","༤","༥","༦","༣"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE,1);
        addQuestions(m11);

        Question m12 = new Question("༢x༢","༢","༤","༣","༥","༤"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE, 1);
        addQuestions(m12);

        Question m13 = new Question("༢x༣","༥","༧","༦","༨","༦"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE,1);
        addQuestions(m13);
        Question m14 = new Question("༣x༣","༨","༡༡","༡༠","༩","༩"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE,1);
        addQuestions(m14);
        Question m15 = new Question("༤x༢","༨","༧","༩","༦","༨"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE,1);
        addQuestions(m15);
        Question m16 = new Question("༤x༤","༡༤","༡༧","༡༦","༡༥","༡༦"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE,1);
        addQuestions(m16);

        //mul_level2
        Question m21 = new Question("༥x༡","༥","༨","༧","༦","༥"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE,2);
        addQuestions(m21);

        Question m22 = new Question("༢x༦","༡༣","༡༢","༡༠","༡༡","༡༢"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE, 2);
        addQuestions(m22);

        Question m23 = new Question("༥x༣","༡༤","༡༦","༡༥","༡༧","༡༥"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE,2);
        addQuestions(m23);
        Question m24 = new Question("༧x༢","༡༢","༡༣","༡༥","༡༤","༡༤"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE,2);
        addQuestions(m24);
        Question m25 = new Question("༦x༤","༢༤","༢༦","༢༥","༢༣","༢༤"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE,2);
        addQuestions(m25);
        Question m26 = new Question("༣x༧","༢༢","༢༡","༢༤","༢༣","༢༡"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE,2);
        addQuestions(m26);

        //mul_level3
        Question m31 = new Question("༦x༥","༣༠","༣༢","༣༡","༣༣","༣༠"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE,3);
        addQuestions(m31);

        Question m32 = new Question("༧x༧","༤༥","༤༩","༤༦","༤༨","༤༩"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE, 3);
        addQuestions(m32);

        Question m33 = new Question("༩x༣","༣༠","༢༨","༢༧","༢༩","༢༧"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE,3);
        addQuestions(m33);
        Question m34 = new Question("༨x༦","༤༧","༤༥","༤༤","༤༨","༤༨"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE,3);
        addQuestions(m34);
        Question m35 = new Question("༤x༧","༢༨","༢༧","༣༠","༢༩","༢༨"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE,3);
        addQuestions(m35);
        Question m36 = new Question("༨x༨","༦༣","༦༤","༦༦","༦༥","༦༤"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE,3);
        addQuestions(m36);

        //mul_level4
        Question m41 = new Question("༩x༨","༧༢","༧༠","༧༣","༧༡","༧༢"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE,4);
        addQuestions(m41);

        Question m42 = new Question("༡༡x༡༠","༡༡༡","༡༡༠","༡༡༣","༡༡༢","༡༡༠"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE, 4);
        addQuestions(m42);

        Question m43 = new Question("༥x༡༢","༥༥","༦༠","༧༠","༦༥","༦༠"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE,4);
        addQuestions(m43);
        Question m44 = new Question("༡༠x༩","༩༡","༩༢","༩༣","༩༠","༩༠"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE,4);
        addQuestions(m44);
        Question m45 = new Question("༨x༡༡","༨༨","༩༠","༨༩","༩༡","༨༨"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE,4);
        addQuestions(m45);
        Question m46 = new Question("༡༣x༧","༩༡","༩༣","༩༢","༩༠","༩༡"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_THREE,4);
        addQuestions(m46);

        //division
        //div_level1
        Question d11 = new Question("༣/༣","༡","༣","༢","༠","༡"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR,1);
        addQuestions(d11);

        Question d12 = new Question("༩/༣","༩","༣","༦","༤","༣"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR, 1);
        addQuestions(d12);

        Question d13 = new Question("༤/༡","༣","༡","༤","༥","༤"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR,1);
        addQuestions(d13);
        Question d14 = new Question("༨/༤","༨","༤","༡༢","༢","༢"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR,1);
        addQuestions(d14);
        Question d15 = new Question("༨/༢","༤","༡༠","༦","༨","༤"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR,1);
        addQuestions(d15);
        Question d16 = new Question("༡༠/༢","༡༢","༥","༨","༡༠","༥"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR,1);
        addQuestions(d16);

        //div_level2
        Question d21 = new Question("༡༢/༤","༣","༨","༤","༦","༣"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR,2);
        addQuestions(d21);

        Question d22 = new Question("༡༨/༣","༥","༦","༧","༨","༦"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR, 2);
        addQuestions(d22);

        Question d23 = new Question("༡༥/༥","༥","༤","༣","༢","༣"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR,2);
        addQuestions(d23);
        Question d24 = new Question("༡༧/༡༧","༡༧","༠","༢","༡","༡"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR,2);
        addQuestions(d24);
        Question d25 = new Question("༡༤/༢","༧","༦","༨","༥","༧"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR,2);
        addQuestions(d25);
        Question d26 = new Question("༡༦/༤","༣","༤","༦","༥","༤"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR,2);
        addQuestions(d26);

        //div_level3
        Question d31 = new Question("༢༦/༡༣","༢","༣","༠","༡","༢"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR,3);
        addQuestions(d31);

        Question d32 = new Question("༢༡/༧","༢","༣","༥","༤","༣"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR, 3);
        addQuestions(d32);

        Question d33 = new Question("༢༤/༤","༥","༧","༦","༨","༦"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR,3);
        addQuestions(d33);
        Question d34 = new Question("༢༠/༥","༦","༧","༥","༤","༤"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR,3);
        addQuestions(d34);
        Question d35 = new Question("༢༩/༣","༩","༡༠","༧","༨","༩"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR,3);
        addQuestions(d35);
        Question d36 = new Question("༢༢/༡༡","༣","༢","༤","༡","༢"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR,3);
        addQuestions(d36);

        //div_level4
        Question d41 = new Question("༣༦/༦","༦","༥","༨","༩","༦"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR,4);
        addQuestions(d41);

        Question d42 = new Question("༤༠/༨","༧","༨","༡༠","༩","༥"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR, 4);
        addQuestions(d42);

        Question d43 = new Question("༣༣/༣","༡༢","༡༤","༡༡","༡༠","༡༡"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR,4);
        addQuestions(d43);
        Question d44 = new Question("༣༦/༡༢","༥","༦","༤","༣","༣"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR,4);
        addQuestions(d44);
        Question d45 = new Question("༣༧/༩","༤","༥","༣","༦","༤"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR,4);
        addQuestions(d45);
        Question d46 = new Question("༣༢/༤","༧","༨","༦","༩","༨"
                ,Question.CATEGORY_TWO,Question.SUBCATEGORY_FOUR,4);
        addQuestions(d46);

        
        //spelling
        //spell_level1
        Question s11 = new Question("སློབ་གྲྭ",null,null,null,null,"སློབ་གྲྭ"
                ,Question.CATEGORY_THREE,null,1);
        addQuestions(s11);

        Question s12 = new Question("ཆུད་ཚོད་འཁོར་ལོ",null,null,null,null,"ཆུད་ཚོད་འཁོར་ལོ"
                ,Question.CATEGORY_THREE,null, 1);
        addQuestions(s12);

        Question s13 = new Question("སོ",null,null,null,null,"སོ"
                ,Question.CATEGORY_THREE,null,1);
        addQuestions(s13);
        Question s14 = new Question("དུང་དཀར་འབུཔ",null,null,null,null,"དུང་དཀར་འབུཔ"
                ,Question.CATEGORY_THREE,null,1);
        addQuestions(s14);
        Question s15 = new Question("འབྲུག་རྒྱལ་དར",null,null,null,null,"འབྲུག་རྒྱལ་དར"
                ,Question.CATEGORY_THREE,null,1);
        addQuestions(s15);
        Question s16 = new Question("འཛམ་གླིང",null,null,null,null,"འཛམ་གླིང"
                ,Question.CATEGORY_THREE,null,1);
        addQuestions(s16);

        //spell_level2
        Question s21 = new Question("སྦ་སྒོར",null,null,null,null,"སྦ་སྒོར"
                ,Question.CATEGORY_THREE,null,2);
        addQuestions(s21);

        Question s22 = new Question("ཕྱེམ་ལ",null,null,null,null,"ཕྱེམ་ལ"
                ,Question.CATEGORY_THREE,null, 2);
        addQuestions(s22);

        Question s23 = new Question("སྒྲོ",null,null,null,null,"སྒྲོ"
                ,Question.CATEGORY_THREE,null,2);
        addQuestions(s23);
        Question s24 = new Question("རི་བོང",null,null,null,null,"རི་བོང"
                ,Question.CATEGORY_THREE,null,2);
        addQuestions(s24);
        Question s25 = new Question("འཕྲུལ་མེ",null,null,null,null,"འཕྲུལ་མེ"
                ,Question.CATEGORY_THREE,null,2);
        addQuestions(s25);
        Question s26 = new Question("སྒྲ་སྙན",null,null,null,null,"སྒྲ་སྙན"
                ,Question.CATEGORY_THREE,null,2);
        addQuestions(s26);

        //spell_level3
        Question s31 = new Question("འབྲུག",null,null,null,null,"འབྲུག"
                ,Question.CATEGORY_THREE,null,3);
        addQuestions(s31);

        Question s32 = new Question("གླིངམ",null,null,null,null,"གླིངམ"
                ,Question.CATEGORY_THREE,null, 3);
        addQuestions(s32);

        Question s33 = new Question("གཞའ",null,null,null,null,"གཞའ"
                ,Question.CATEGORY_THREE,null,3);
        addQuestions(s33);
        Question s34 = new Question("ཉན་ཆས",null,null,null,null,"ཉན་ཆས"
                ,Question.CATEGORY_THREE,null,3);
        addQuestions(s34);
        Question s35 = new Question("མགུ་ཤད",null,null,null,null,"མགུ་ཤད"
                ,Question.CATEGORY_THREE,null,3);
        addQuestions(s35);
        Question s36 = new Question("ཉི་གདུགས",null,null,null,null,"ཉི་གདུགས"
                ,Question.CATEGORY_THREE,null,3);
        addQuestions(s36);

        //spell_level4
        Question s41 = new Question("མེ་ལོང",null,null,null,null,"མེ་ལོང"
                ,Question.CATEGORY_THREE,null,4);
        addQuestions(s41);

        Question s42 = new Question("ཨེ་ཏོ་མེ་ཏོག",null,null,null,null,"ཨེ་ཏོ་མེ་ཏོག"
                ,Question.CATEGORY_THREE,null, 4);
        addQuestions(s42);

        Question s43 = new Question("ངང་ལག",null,null,null,null,"ངང་ལག"
                ,Question.CATEGORY_THREE,null,4);
        addQuestions(s43);
        Question s44 = new Question("ལགཔ",null,null,null,null,"ལགཔ"
                ,Question.CATEGORY_THREE,null,4);
        addQuestions(s44);
        Question s45 = new Question("མིག་ཤེལ",null,null,null,null,"མིག་ཤེལ"
                ,Question.CATEGORY_THREE,null,4);
        addQuestions(s45);
        Question s46 = new Question("ཤིང",null,null,null,null,"ཤིང"
                ,Question.CATEGORY_THREE,null,4);
        addQuestions(s46);


    }

    private void addQuestions(Question question){

        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1,question.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2,question.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3,question.getOption3());
        cv.put(QuestionTable.COLUMN_OPTION4,question.getOption4());
        cv.put(QuestionTable.COLUMN_ANSWER_NR,question.getAnswerNr());
        cv.put(QuestionTable.COLUMN_SUBCATEGORY,question.getSubcategory());
        cv.put(QuestionTable.COLUMN_CATEGORY,question.getCategory());
        cv.put(QuestionTable.COLUMN_LEVELS_ID,question.getLevels());
        db.insert(QuestionTable.TABLE_NAME,null,cv);

    }

    public ArrayList<Question> getAllQuestions() {

        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();



        String Projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_ANSWER_NR
        };



        Cursor c = db.query(QuestionTable.TABLE_NAME,
                Projection,
                null,
                null,
                null,
                null,
                null);


        if (c.moveToFirst()) {
            do {

                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getString(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));

                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        return questionList;
    }

    public ArrayList<Question> getQuestionsWithCategory(String Category) {

        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();



        String Projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_ANSWER_NR,
                QuestionTable.COLUMN_CATEGORY
        };

        String selection = QuestionTable.COLUMN_CATEGORY + " = ? ";
        String selectionArgs[] = {Category};


        Cursor c = db.query(QuestionTable.TABLE_NAME,
                Projection,
                selection,
                selectionArgs,
                null,
                null,
                null);


        if (c.moveToFirst()) {
            do {

                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getString(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                question.setCategory(c.getString(c.getColumnIndex(QuestionTable.COLUMN_CATEGORY)));

                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        return questionList;
    }

    public ArrayList<Question> getQuestionsByLevelsAndCategory(String Category, int LevelsID) {

        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();



        String Projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_ANSWER_NR,
                QuestionTable.COLUMN_CATEGORY,
                QuestionTable.COLUMN_LEVELS_ID
        };

        String selection = QuestionTable.COLUMN_LEVELS_ID + " = ? "
                + " AND " + QuestionTable.COLUMN_CATEGORY + " = ? ";

        String selectionArgs[] = new String[] {String.valueOf(LevelsID),Category};


        Cursor c = db.query(QuestionTable.TABLE_NAME,
                Projection,
                selection,
                selectionArgs,
                null,
                null,
                null);


        if (c.moveToFirst()) {
            do {

                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getString(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                question.setCategory(c.getString(c.getColumnIndex(QuestionTable.COLUMN_CATEGORY)));
                question.setLevels(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_LEVELS_ID)));
                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        return questionList;
    }


    public ArrayList<Question> getQuestionsByLevelsAndCategoryAndSubCategory(String Category,String Subcategory, int LevelsID) {

        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();



        String Projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_ANSWER_NR,
                QuestionTable.COLUMN_CATEGORY,
                QuestionTable.COLUMN_SUBCATEGORY,
                QuestionTable.COLUMN_LEVELS_ID
        };

        String selection = QuestionTable.COLUMN_LEVELS_ID + " = ? "
                + " AND " + QuestionTable.COLUMN_CATEGORY + " = ? "
                + " AND "+ QuestionTable.COLUMN_SUBCATEGORY + " = ? ";

        String selectionArgs[] = new String[] {String.valueOf(LevelsID),Category, Subcategory};
        Log.d("mess","LevelsID"+String.valueOf(LevelsID));
        Log.d("mess",Category);
        Log.d("mess",Subcategory);

        Cursor c = db.query(QuestionTable.TABLE_NAME,
                Projection,
                selection,
                selectionArgs,
                null,
                null,
                null);


        if (c.moveToFirst()) {
            do {

                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getString(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                question.setCategory(c.getString(c.getColumnIndex(QuestionTable.COLUMN_CATEGORY)));
                question.setSubcategory(c.getString(c.getColumnIndex(QuestionTable.COLUMN_SUBCATEGORY)));
                question.setLevels(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_LEVELS_ID)));
                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        Log.d("size", String.valueOf(questionList.size()));
        return questionList;
    }

}

