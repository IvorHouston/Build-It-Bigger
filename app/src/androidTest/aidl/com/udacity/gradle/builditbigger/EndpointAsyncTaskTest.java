package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.EndpointAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;

public class EndpointAsyncTaskTest {

    @RunWith(AndroidJUnit4.class)
    public class EndPointAsyncTaskTest {
        String result;

        @Test
        public void testDoInBackground() throws Exception {
            com.udacity.gradle.builditbigger.MainActivityFragment fragment = new com.udacity.gradle.builditbigger.MainActivityFragment();
            fragment.testFlag = true;
            new EndpointAsyncTask().execute(fragment);
            Thread.sleep(5000);
            assertTrue("Error: Fetched Joke = " + fragment.loadedJoke, fragment.loadedJoke != null);

            try{

                //Default timeout for the GCM server is 20 seconds
                //If the .get can't get the result in 10 seconds, something is wrong anyway
                //Greater than 20 seconds results in an error string returned and requires further interpretation
                //endpointAsyncTask.execute(new android.util.Pair<Context, String>(mockContext,joker.getJoke() ));
                new EndpointAsyncTask().execute();
                result = new EndpointAsyncTask().get(10, TimeUnit.SECONDS);
                assertNotNull(result);

            }catch (Exception e){
                fail("Timed out");
            }
        }


    }
}