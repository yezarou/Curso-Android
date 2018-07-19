package example.android9ed.appinfo;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;

import java.util.ArrayList;
import java.util.List;

public class AppUtil {
    public static ArrayList<Permisos> todosPermisos(Context ctx){
        PackageManager pm = ctx.getPackageManager();
        CharSequence csPermissionLabel;
        List<PermissionGroupInfo> lstGroups = pm.getAllPermissionGroups(0);
        ArrayList<Permisos> permisos = new ArrayList<>();
        for (PermissionGroupInfo pgi : lstGroups) {
            try {
                List<PermissionInfo> lstPermissions = pm.queryPermissionsByGroup(pgi.name,
                        0);
                for (PermissionInfo pi : lstPermissions) {
                    csPermissionLabel = pi.loadDescription(pm);
                    Permisos perm = new Permisos(pi.name, csPermissionLabel.toString());
                    permisos.add(perm);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return permisos;
    }
}
