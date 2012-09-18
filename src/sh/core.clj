(ns sh.core
   (:use clojure.java.shell
         [clojure.template :only [do-template]]))

(defn sh-c
  "sh with a string composed of command [args]"
  [#^String s]
  (sh "/bin/sh" "-c" s))


;;input processing
(defn string [args] 
   (apply str (interpose " " args)))

(defn idiomatic-arg [k]
   (str "-" (name k)))

(defn idiomatize-args [l]
   "apply idiomatic-arg on keywords"
   (map #(if (keyword? %) (idiomatic-arg %) %) l))

(defn i [args]
   (idiomatize-args args))


;;output processing
(defn lista [#^String s]
   "partition a list into strings, by line breaks"
   (re-seq #"[^\n]+" s))

(defn o [k]
   (lista (:out k)))

(do-template
   [cmd]
   (defn cmd [& args] (o (apply sh (i (cons (str (quote cmd)) args)))))

apt-get
aptitude
aspell
awk
basename
bc
bg
break
builtin
bzip2
cal
cat
cd
cfdisk
chgrp
chmod
chown
chroot
chkconfig
cksum
cmp
comm
command
continue
cp
cron
crontab
csplit
curl
cut
date
dc
dd
ddrescue
df
diff
diff3
dig
dircolors
dirname
dirs
dmesg
du
echo
egrep
eject
enable
env
exec
exit
expect
expand
export
expr
fdformat
fdisk
fg
fgrep
fmt
fold
fsck
function
fuser
gawk
getopts
git
grep
groups
gzip
head
history
hostname
iconv
id
ifconfig
ifdown
ifup
install
jobs
join
kill
killall
lein
ln
local
locate
logname
logout
look
lpc
lpr
lprm
ls
lsof
man
mkdir
mkfifo
mknod
mount
mtools
mtr
mv
mmv
nice
nl
nohup
notify-send
nslookup
open
op
passwd
paste
ping
pkill
popd
ps
pushd
pwd
quota
quotacheck
quotactl
ram
rcp
readonly
rename
return
rev
rm
rmdir
rsync
screen
scp
sdiff
sed
select
shift
shopt
shutdown
sleep
slocate
split
ssh
su
sudo
sum
suspend
symlink
tail
tar
tee
times
touch
top
traceroute
tr
tsort
tty
ulimit
umask
unalias
uname
unexpand
uniq
units
unset
unshar
until
useradd
usermod
users
uuencode
uudecode
vmstat
watch
wc
wget
whereis
which
who
whoami
write
xargs
xdg-open
yes
!!
  )
