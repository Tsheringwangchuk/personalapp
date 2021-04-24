package edu.gcit.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import edu.gcit.project.QContract.*;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class QDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Addition.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
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
                QuestionTable.COLUMN_ANSWER_NO + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        Question q1 = new Question("༢ + ༡", "༣", "༢", "༡", 1);
        addQuestion(q1);

        Question q2 = new Question("༢ + ༣", "༥", "༧", "༤", 1);
        addQuestion(q2);

        Question q3 = new Question("༣ + ༤", "༨", "༦", "༧", 3);
        addQuestion(q3);

        Question q4 = new Question("༤ + ༥", "༩", "༧", "༡༠", 1);
        addQuestion(q4);

        Question q5 = new Question("༩ + ༢", "༡༠", "༡༡", "༡༢", 2);
        addQuestion(q5);

        Question q6 = new Question("༥ + ༧", "༩", "༡༤", "༡༢", 3);
        addQuestion(q6);

        Question q7 = new Question("༥ + ༩", "༡༩", "༡༤", "༡༥", 2);
        addQuestion(q7);

        Question q8 = new Question("༧ + ༡༠", "༡༧", "༡༨", "༡༥", 1);
        addQuestion(q8);

        Question q9 = new Question("༨ + ༡༡", "༢༠", "༡༧", "༡༩", 3);
        addQuestion(q9);

        Question q10 = new Question("༡༠ + ༡༡", "༢༥", "༢༡", "༢༢", 2);
        addQuestion(q10);
    }

    private  void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionTable.COLUMN_ANSWER_NO, question.getAnswerNo());
        db.insert(QuestionTable.TABLE_NAME, null, cv);
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "  + QuestionTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setAnswerNo(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NO)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}

