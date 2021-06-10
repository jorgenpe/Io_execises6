package Data;

public abstract class AbstractDAOCloseHelper {

    protected void closeAll(AutoCloseable ... closeables){

        if(closeables != null){

            for(AutoCloseable m : closeables){

                if(m != null){
                    try{
                        m.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }



    }
}
