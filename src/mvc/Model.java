package mvc;

//import tools.*;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Model extends Bean {

    private Boolean unsavedChanges = false;
    private String fileName = null;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String newFileName) {
        fileName = newFileName;
    }
    
    public void setUnsavedChanges(boolean b) { unsavedChanges = b; }
    public boolean getUnsavedChanges() { return unsavedChanges; }

    public void changed() {
        firePropertyChange("unsavedChanges", unsavedChanges, true);
        unsavedChanges = true;
    }

    public void saved() {
        unsavedChanges = false;
    }

}
