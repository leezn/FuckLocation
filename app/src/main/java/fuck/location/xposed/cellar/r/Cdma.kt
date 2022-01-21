package fuck.location.xposed.cellar.r

import android.telephony.CellIdentity
import com.github.kyuubiran.ezxhelper.utils.*
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.callbacks.XC_LoadPackage

class Cdma(){
    fun HookCellIdentity(lpparam: XC_LoadPackage.LoadPackageParam) {
        val clazz: Class<*> = lpparam.classLoader.loadClass("android.telephony.CellIdentityCdma")
        XposedBridge.log("FL: Finding method in HookCellIdentity (CDMA)")
        findAllMethods(clazz) {
            name == "getNetworkId" && isPublic
        }.hookMethod {
            after { param ->
                XposedBridge.log("FL: in getNetworkId! Caller package name: " + param.args[0])
                var cid = param.result as CellIdentity
            }
        }

        findAllMethods(clazz) {
            name == "getSystemId" && isPublic
        }.hookMethod {
            after { param ->
                XposedBridge.log("FL: in getSystemId! Caller package name: " + param.args[0])
                var cid = param.result as CellIdentity
            }
        }

        findAllMethods(clazz) {
            name == "getBasestationId" && isPublic
        }.hookMethod {
            after { param ->
                XposedBridge.log("FL: in getBasestationId! Caller package name: " + param.args[0])
                var cid = param.result as CellIdentity
            }
        }

        findAllMethods(clazz) {
            name == "getLongitude" && isPublic
        }.hookMethod {
            after { param ->
                XposedBridge.log("FL: in getLongitude! Caller package name: " + param.args[0])
                var cid = param.result as CellIdentity
            }
        }

        findAllMethods(clazz) {
            name == "getLatitude" && isPublic
        }.hookMethod {
            after { param ->
                XposedBridge.log("FL: in getLatitude! Caller package name: " + param.args[0])
                var cid = param.result as CellIdentity
            }
        }
    }
}