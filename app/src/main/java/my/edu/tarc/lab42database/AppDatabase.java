package my.edu.tarc.lab42database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


//TODO 5: Create a database class

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    //create an instance of the room database
    private static volatile AppDatabase INSTANCE;

    //create an instance of the DAO
    public abstract UserDao userDao();

    static AppDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (AppDatabase.class){
                if(INSTANCE == null){
                    //Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "user_db")
                    .build();
                }
            }
        }
        return INSTANCE;
    }

}
