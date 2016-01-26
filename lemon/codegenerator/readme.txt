根据数据库表自动生成Entity，Service，Dao

操作步骤:
	1.进入codegen里config的generator.properties，配置好数据库连接
	2.找到specifiedTables文件,添加表名（支持多个表，多个表注意换行）
	3.找到PackageNames.properties，配置 表名=af（支持多个表，多个表注意换行）
	4.找到build.xml，右键run as  选择ant build
	5.生成成功，文件自动生成到包路径com.jeecms.af对应的entity，service，dao下