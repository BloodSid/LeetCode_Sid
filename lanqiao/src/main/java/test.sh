#!/bin/bash

# 编译程序和数据生成器
javac -encoding UTF-8 contest2024/H/Main.java
javac -encoding UTF-8 contest2024/H/Main2.java
javac -encoding UTF-8 contest2024/H/TestGen.java

# 对拍次数
for i in {1..100}
do
    # 生成测试数据
    java -Xss100M contest2024.H.TestGen > contest2024/H/in.txt

    # 运行两个程序
    java -Xss100M contest2024.H.Main < contest2024/H/in.txt > contest2024/H/out.txt
    java -Xss100M contest2024.H.Main2 < contest2024/H/in.txt > contest2024/H/out2.txt

    echo "answer is :"
    cat contest2024/H/out.txt
    # 比较输出
    if diff contest2024/H/out.txt contest2024/H/out2.txt > /dev/null ; then
        echo "Test $i: Passed"
    else
        echo "Test $i: Failed"
        exit 1
    fi
done

echo "All tests passed."
