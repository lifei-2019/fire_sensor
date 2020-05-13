#!/bin/bash
# james
Dir=`pwd`
jar_pid=$Dir/jar_pid
if [ ! -d "$jar_pid" ]; then
   mkdir $jar_pid
fi
nohup java -jar $Dir/sensor.jar --spring.profiles.active=test  & #后台启动，错误 输出重定向到out.file文件
echo $! > $jar_pid/jar_startup.pid   # 将jar包启动对应的pid写入文件中，为停止时提供pid

#date=`date +%Y%m%d`
#/data/mysql/bin/mysqldump -uxzyx -p'Gdoss' iebm_one_system > /data/mysql_bak/iebm_one_system_$date.sql


