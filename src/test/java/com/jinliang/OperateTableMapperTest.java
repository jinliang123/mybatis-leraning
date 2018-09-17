package com.jinliang;

import com.jinliang.domain.Column;
import com.jinliang.domain.TableColumn;
import com.jinliang.mapper.CreateMysqlTablesMapper;
import com.jinliang.mapper.OperateTableMapper;
import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PutMapping;

import java.sql.JDBCType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description
 *
 * @author liang.jin@hand-china.com 2018/09/12 15:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OperateTableMapperTest {
    @Autowired
    private OperateTableMapper operateTableMapper;
    @Autowired
    private CreateMysqlTablesMapper tablesMapper;
    @Test
    public void testCreate(){
        System.out.println("开始只想创建表");
        String createTable ="create table iam_test"
                +"(`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录ID',"
                +"`type` int(11) DEFAULT NULL COMMENT '记录类别；0=电催；1=CP；2=评语；3=调案；',"
                +"`caseid` varchar(50) DEFAULT NULL COMMENT '案件编号', "
                +"`doccode` varchar(50) DEFAULT NULL COMMENT '债务人身份证号',"
                +"`name` varchar(50) DEFAULT NULL COMMENT '通话人姓名',"
                +"`phone` varchar(80) DEFAULT NULL COMMENT '电话号码',"
                +"`summary` varchar(8) DEFAULT NULL COMMENT '联络摘要',"
                +"`infor` varchar(10000) DEFAULT NULL COMMENT '通话内容',"
                +"`userid` int(11) DEFAULT NULL COMMENT '业务员ID', "
                +"`companycode` varchar(30) DEFAULT NULL COMMENT '催收公司编码',"
                +"`callDate` timestamp NULL DEFAULT NULL COMMENT '联络日期', "
                +"`direction` int(11) DEFAULT NULL COMMENT '通话方向；0=呼出；1=呼入',"
                +"`relation` int(11) DEFAULT NULL COMMENT '关系；1=本人；2=直系；3=亲属；4=联系人；5=担保人；6=其他', "
                +"`cardcode` varchar(50) DEFAULT NULL COMMENT 'cardcode/contractcode合并为此一个字段，type用来区分使用哪一个\r\ntype=0 信用卡，type=1非信用卡',"
                +"`cardtype` int(2) DEFAULT NULL COMMENT '0=信用卡 1=非信用卡',"
                +"`recordid` int(11) DEFAULT NULL COMMENT '通话记录主键Id',"
                +"`commtype` varchar(10) DEFAULT NULL COMMENT '联系方式：手机，司电，宅电 新表添加此字段',"
                +"PRIMARY KEY (`id`), "
                +"KEY `caseid_index` (`caseid`) USING BTREE"
                +")ENGINE=InnoDB DEFAULT CHARSET=utf8";

        operateTableMapper.createNewTable(createTable);
    }

    @Test
    public void testUpdate(){
        String updateTable = "alter table iam_test MODIFY phone varchar(90)";
        operateTableMapper.updateTable(updateTable);

    }


    @Test
    public void createTable(){
        String tableName = "iam_user";
        List<Column> columns = new ArrayList<>();
        columns.add(new Column("id","Integer",10));
        columns.add(new Column("age","Integer",10));

        StringBuilder sb = new StringBuilder();
//        for(Column column : columns){
//            sb.append(column.getName()+" "+column.getType()+" "+column.getLength()+",");
//        }
        for(int i = 0; i < columns.size()-1; i++) {
            sb.append(columns.get(i).getName()+" "+columns.get(i).getType()+"("+columns.get(i).getLength()+")"+",");
        }
        sb.append(columns.get(columns.size()-1).getName()+" "+columns.get(columns.size()-1).getType()+"("+columns.get(columns.size()-1).getLength()+")");


        System.out.println(sb.toString());
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE ")
                .append(tableName)
                .append("(")
                .append(sb.toString())
                .append(")");


//        operateTableMapper.createTable(tableName,columns);
        operateTableMapper.createNewTable(sql.toString());

    }


    /**
     * 创建表
     */
    @Test
    public void test(){
        Map<String, List<TableColumn>> tableMap = new HashMap<>();
        List<TableColumn> columns = new ArrayList<>();
        TableColumn tableColumn = new TableColumn();
        tableColumn.setFieldName("id");
        tableColumn.setFieldType(JDBCType.INTEGER.getName());
        tableColumn.setFieldLength(20);
        tableColumn.setFieldIsPrimaryKey(true);
        tableColumn.setFieldIsAutoIncrement(true);
//        tableColumn.setFieldIsNull(false);
//        tableColumn.setFieldIsAutoIncrement(false);
        tableColumn.setFileTypeLength(1);
        tableColumn.setFieldComment("表ID，主键，供其他表做外键");
        tableColumn.setFieldDefaultValue("1");
        columns.add(tableColumn);
        TableColumn tableColumn1 = new TableColumn();
        tableColumn1.setFieldName("name");
        tableColumn1.setFieldType(JDBCType.VARCHAR.getName());
        tableColumn1.setFieldLength(20);
        tableColumn1.setFileTypeLength(1);
        tableColumn1.setFieldComment("名称");
//        tableColumn1.setFieldDefaultValue("test");
        tableColumn1.setFieldIsNull(true);

        tableColumn1.setFieldIsUnique(true);
        columns.add(tableColumn1);
        tableMap.put("iam_user",columns);
        tableMap.put("iam_role",columns);
        tablesMapper.createTable(tableMap);
    }

    @Test
    public void addCloumn(){
        Map<String, List<TableColumn>> tableMap = new HashMap<>();
//        Map<String,TableColumn> tableMap= new HashMap<>();
        List<TableColumn> columns = new ArrayList<>();
        TableColumn tableColumn = new TableColumn();
        tableColumn.setFieldName("name");
        tableColumn.setFieldType("varchar");
        tableColumn.setFieldLength(2);
        tableColumn.setFieldIsNull(true);
//        tableColumn.setFieldIsAutoIncrement(false);
        tableColumn.setFileTypeLength(1);
        tableColumn.setFieldComment("姓名");
        columns.add(tableColumn);
        TableColumn tableColumn1 = new TableColumn();
        tableColumn1.setFieldName("sex");
        tableColumn1.setFieldType("INTEGER");
        tableColumn1.setFieldLength(2);
        tableColumn1.setFieldIsNull(true);
//        tableColumn.setFieldIsAutoIncrement(false);
        tableColumn1.setFileTypeLength(1);
        tableColumn1.setFieldComment("性别");
        columns.add(tableColumn1);
        tableMap.put("iam_user",columns);
//        tableMap.put("iam_user",tableColumn);
        tablesMapper.addTableField(tableMap);
    }



    @Test
    public void modifyCloumn(){
        Map<String, List<TableColumn>> tableMap = new HashMap<>();
//        Map<String,TableColumn> tableMap= new HashMap<>();
        List<TableColumn> columns = new ArrayList<>();
        TableColumn tableColumn = new TableColumn();
        tableColumn.setFieldName("name");
        tableColumn.setFieldType("INTEGER");
        tableColumn.setFieldLength(2);
        tableColumn.setFieldIsNull(true);
//        tableColumn.setFieldIsAutoIncrement(false);
        tableColumn.setFileTypeLength(1);
        tableColumn.setFieldComment("年龄");
        columns.add(tableColumn);
        TableColumn tableColumn1 = new TableColumn();
        tableColumn1.setFieldName("sex");
        tableColumn1.setFieldType("INTEGER");
        tableColumn1.setFieldLength(20);
        tableColumn1.setFieldIsNull(true);
//        tableColumn.setFieldIsAutoIncrement(false);
        tableColumn1.setFileTypeLength(1);
        tableColumn1.setFieldComment("性别");
        columns.add(tableColumn1);
        tableMap.put("iam_user",columns);
//        tableMap.put("iam_user",tableColumn);
        tablesMapper.modifyTableField(tableMap);
    }

    @Test
    public void checkTable(){
        String tableName = "iam_user";
        String tableCountByTableName = tablesMapper.findTableCountByTableName(tableName);
        System.out.println(tableCountByTableName);

    }

}
