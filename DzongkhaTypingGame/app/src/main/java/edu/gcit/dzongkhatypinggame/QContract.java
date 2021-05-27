package edu.gcit.dzongkhatypinggame;

import android.provider.BaseColumns;

public final class QContract {


    public QContract() {
    }

    public static class QuestionTable implements BaseColumns {

        public static final String TABLE_NAME = "MyTable";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_ANSWER_NR = "answer_nr";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_LEVELS_ID = "levels_id";
    }
}