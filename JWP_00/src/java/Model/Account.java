
package Model;

/**
 *
 * @author root
 */
public class Account {
//    create table ACCOUNT(
//UserId int primary key,
//Username varchar(32) not null,
//PWD varchar(16) not null,  
//RoleId int references Role(RoleId),
//ProfileId int references Profile(ProfileId)
//)
    private int UserId;
    private String Username;
    private String PWD;
    private int RoleId;
    private int ProfileId;
    
    public Account(){
    }

    public Account(int UserId, String Username, String PWD, int RoleId, int ProfileId) {
        this.UserId = UserId;
        this.Username = Username;
        this.PWD = PWD;
        this.RoleId = RoleId;
        this.ProfileId = ProfileId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPWD() {
        return PWD;
    }

    public void setPWD(String PWD) {
        this.PWD = PWD;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int RoleId) {
        this.RoleId = RoleId;
    }

    public int getProfileId() {
        return ProfileId;
    }

    public void setProfileId(int ProfileId) {
        this.ProfileId = ProfileId;
    }
    
    
}
