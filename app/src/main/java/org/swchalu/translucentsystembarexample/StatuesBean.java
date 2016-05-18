package org.swchalu.translucentsystembarexample;

/**
 * Created by swc12 on 2016/5/18 0018.
 */
public class StatuesBean {
    private boolean hasMulitPics = false;
    private String userName;
    private String content;
    private String timestamp;
    private int type = Constants.TYPE_SINGLEPIC;

    public boolean isHasMulitPics() {
        return hasMulitPics;
    }

    public void setHasMulitPics(boolean hasMulitPics) {
        this.hasMulitPics = hasMulitPics;
        setType(isHasMulitPics() ? Constants.TYPE_MULITPIC : Constants.TYPE_SINGLEPIC);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
