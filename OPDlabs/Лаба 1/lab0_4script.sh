cd lab0 || exit
wc -m dwebble6 >> dwebble6
find . -name "*0" 2>/tmp/err
cat dwebble6 2>&1 | grep -in "dbu"
grep -lR "ke" 2>/dev/null| xargs ls -l | sort -n -k 2
wc -m  *0 */*0 */*/*0 */*/*/*0 2>&1 | sort -n
wc -m  *0 */*0 */*/*0 */*/*/*0 2>/tmp/err| sort -rn
cd ..
