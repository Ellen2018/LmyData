package com.ellen.lmydata;

import com.ellen.dhcsqlitelibrary.table.impl.ZxyLibrary;
import com.ellen.lmydata.sql.LoginTable;
import com.ellen.sqlitecreate.createsql.helper.WhereSymbolEnum;
import com.ellen.sqlitecreate.createsql.where.Where;
import com.google.gson.Gson;

import java.util.List;

public class LoginHttpsEmulator implements LmyHttpsEmulator {

    private LoginTable loginTable;

    public LoginHttpsEmulator(ZxyLibrary zxyLibrary) {
        loginTable = new LoginTable(zxyLibrary, "login_table");
        loginTable.onCreateTableIfNotExits();
    }

    @Override
    public void initData(boolean isInit) {
        if(!isInit) {
            for (int i = 0; i < 10; i++) {
                LoginBean loginBean = new LoginBean();
                loginBean.setAccount("Ellen" + i);
                loginBean.setPassword("" + i);
                loginTable.saveData(loginBean);
            }
        }
    }

    @Override
    public String url() {
        return "https://www.chen.com";
    }

    @Override
    public RequestParams.RequestType type() {
        return RequestParams.RequestType.GET;
    }

    @Override
    public String json(RequestParams requestParams) {
        Gson gson = new Gson();
        String account = (String) requestParams.getGetFieldValues().get("account");
        String password = (String) requestParams.getGetFieldValues().get("password");
        String searchSql = Where.getInstance(false)
                .addAndWhereValue("account", WhereSymbolEnum.EQUAL, account)
                .addAndWhereValue("password", WhereSymbolEnum.EQUAL, password)
                .createSQL();
        List<LoginBean> loginBeans = loginTable.search(searchSql, null);
        LoginBean loginBean = null;
        if (loginBeans.size() == 0) {
            //查询不到
            loginBean = new LoginBean();

            loginBean.setCode(404);
            String searchSqlAccount = Where.getInstance(false)
                    .addAndWhereValue("account", WhereSymbolEnum.EQUAL, account)
                    .createSQL();
            String searchSqlPassword = Where.getInstance(false)
                    .addAndWhereValue("account", WhereSymbolEnum.EQUAL, account)
                    .addAndWhereValue("password", WhereSymbolEnum.EQUAL, password)
                    .createSQL();

            if(loginTable.search(searchSqlAccount,null).size() == 0 ){
                loginBean.setMessage("未查询到此账号:"+account);
            }else {
                if(loginTable.search(searchSqlPassword,null).size() == 0){
                    loginBean.setMessage("密码错误!");
                }else {
                    loginBean.setMessage("未知错误");
                }
            }
        } else {
            loginBean = loginBeans.get(0);
            loginBean.setMessage("登录成功");
            loginBean.setUserName(loginBean.getAccount());
            loginBean.setImgUrl("https://588ku.com/sucai/0-default-0-0-0-0-1/?h=bd&sem=1&kw=st0000001&bd_vid=9168368572989010190");
        }
        return gson.toJson(loginBean);
    }
}
