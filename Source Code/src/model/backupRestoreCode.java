
package model;

import org.apache.log4j.Logger;


public class backupRestoreCode {
    
    static Logger log = Logger.getLogger(backupRestoreCode.class.getName());
    
    public backupRestoreCode() {
    }
    
    public String backupDB(String path){
        
        String msg = null;
        
        try {
            Runtime runtime = Runtime.getRuntime();
            Process p = runtime.exec("C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump -uroot -pComp@123 --port=3307 --add-drop-database -B "
                    + " lol -r "+path);
            
            int processComplete = p.waitFor();
            System.out.println("Done"+processComplete);
            msg = "Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Error "+e.getMessage();
            log.debug(e.getMessage());
        }
        return msg;
    }
    
    public String restoreDB(String path){
        
        String msg = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            String[] restoreCmd = new String[]{"C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysql.exe",
                    "--user=root",
                    "--password=Comp@123",
                    "--port=3307",
                    "-e",
                    " source " + path};
            
            Process p = runtime.exec(restoreCmd);
            int processComplete = p.waitFor();
            System.out.println("Restore Process Done"+processComplete);
            msg = "Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Error "+e.getMessage();
            log.debug(e.getMessage());
        }
        return msg;
    }
}
