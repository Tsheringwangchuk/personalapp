package edu.gcit.dzongkhatypinggame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import edu.gcit.dzongkhatypinggame.QContract.*;

import java.util.ArrayList;

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
                QuestionTable.COLUMN_ANSWER_NR + " TEXT, " +
                QuestionTable.COLUMN_CATEGORY + " TEXT " +

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

        //spell_level4
        Question s11 = new Question("མེ་ལོང","མེ་ལོང"
                ,Question.CATEGORY_ONE);
        addQuestions(s11);

        Question s12 = new Question("ཨེ་ཏོ་མེ་ཏོག","ཨེ་ཏོ་མེ་ཏོག"
                ,Question.CATEGORY_ONE);
        addQuestions(s12);

        Question s13 = new Question("ངང་ལག","ངང་ལག"
                ,Question.CATEGORY_ONE);
        addQuestions(s13);
        Question s14 = new Question("ལགཔ","ལགཔ"
                ,Question.CATEGORY_ONE);
        addQuestions(s14);
        Question s15 = new Question("མིག་ཤེལ","མིག་ཤེལ"
                ,Question.CATEGORY_ONE);
        addQuestions(s15);
        Question s16 = new Question("ཤིང","ཤིང"
                ,Question.CATEGORY_ONE);
        addQuestions(s16);

        //spell_level1
        Question s21 = new Question("མེ་ལོང","མེ་ལོང"
                ,Question.CATEGORY_TWO);
        addQuestions(s21);

        Question s22 = new Question("ཨེ་ཏོ་མེ་ཏོག","ཨེ་ཏོ་མེ་ཏོག"
                ,Question.CATEGORY_TWO);
        addQuestions(s22);

        Question s23 = new Question("ངང་ལག","ངང་ལག"
                ,Question.CATEGORY_TWO);
        addQuestions(s23);
        Question s24 = new Question("ལགཔ","ལགཔ"
                ,Question.CATEGORY_TWO);
        addQuestions(s24);
        Question s25 = new Question("མིག་ཤེལ","མིག་ཤེལ"
                ,Question.CATEGORY_TWO);
        addQuestions(s25);
        Question s26 = new Question("ཤིང","ཤིང"
                ,Question.CATEGORY_TWO);
        addQuestions(s26);


    }

    private void addQuestions(Question question){

        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuestionTable.COLUMN_ANSWER_NR,question.getAnswerNr());
        cv.put(QuestionTable.COLUMN_CATEGORY,question.getCategory());
        db.insert(QuestionTable.TABLE_NAME,null,cv);

    }

    public ArrayList<Question> getAllQuestions() {

        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();



        String Projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
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
                question.setAnswerNr(c.getString(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                question.setCategory(c.getString(c.getColumnIndex(QuestionTable.COLUMN_CATEGORY)));

                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        return questionList;
    }

    public ArrayList<Question> getQuestionsByCategory(String Category) {

        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();



        String Projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_ANSWER_NR,
                QuestionTable.COLUMN_CATEGORY,
        };

        String selection = QuestionTable.COLUMN_CATEGORY + " = ? ";

        String selectionArgs[] = new String[] {Category};


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
                question.setAnswerNr(c.getString(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                question.setCategory(c.getString(c.getColumnIndex(QuestionTable.COLUMN_CATEGORY)));
                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        return questionList;
    }

}



