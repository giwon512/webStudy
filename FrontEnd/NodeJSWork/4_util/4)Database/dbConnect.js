const oracledb = require("oracledb");
const dbconfig = require("./root/dbconfig");
oracledb.autoCommit = true;

function init() {
    oracledb.initOracleClient({libDir : "C:\\instantclient_21_14"});
}

init();

oracledb.getConnection({
    user : dbconfig.user,
    password : dbconfig.password,
    connectionString : dbconfig.connectString
}, (err, conn) => {
    // init();
    console.log("connection : ", conn);

    let sql;

    //create
    // sql = "create table cuser(id varchar2(10), name varchar2(10), age number)";
    // conn.execute(sql);
    // console.log("table created");

    // sql = "insert into cuser values(:id, :name, :age)";
    // // binds = [["id01", "TOM", 27]];
    // binds = [["id02", "JOHN", 20], ["id03", "Jeniffer", 21]];
    // let result = conn.executeMany(sql, binds, {});
    // console.log(result);

    // sql = "update cuser set name=:name, age=:age where id=:id";
    // conn.executeMany(sql, [["Jerry", 30, "id03"]]);
    // console.log("update finished");

    // sql = "delete from cuser where id=:id";
    // conn.executeMany(sql, [["id03"]]);
    // console.log("deleted");

    sql = "select * from cuser";
    conn.execute(sql, [], (err, result)=>{
        if(err){
            throw err;
        }
        console.log(result.rows);
    });
    conn.release((err)=>{
        if(err){
            throw err;
        }
    });
});