# Redis Commands

* set student "Anna"
* set student:1 "Anna"
* get student
* get student:1

* keys * ---- get all keys
* key stu* --- get all keys for starting with "stu"

* set student:1 "Anna" ex 25 --- set expire date for record
* ttl student:1 ---- check remaining time for record
* set student:1 ex 20 nx ----- set key if not exist(nx)
* set student:1 ex 20 xx ---- set key if already exist(xx)

* exists student:1

* append student "John" ---append string 

* strlen student --- length of string

* set mykey 10 
* incr mykey --- increment 11
* incrby mykey 10 --- 21

* decr mykey --- 20  
* decrby mykey 10 --- 10 

* set rangekey rangeone
* setrange rangekey 5 two
(integer) 8
* get rangekey
"rangetwo"
* getrange rangekey 5 8
"two"



* mset firstkey firstvalue secondkey secondvalue
* mget firstkey secondkey
1) "firstvalue"
2) "secondvalue"

* lists
* lpush tutorials tut1 tut2 tut3
* lrange tutorials 0 1
* rpush tutorials tut4
1) "tut3"
2) "tut2"
3) "tut1"
4) "tut4"

* llen tutorials
(integer) 4
* lset tutorials 2 "tutorial 2"
* lrange tutorials 0 3
1) "tut3"
2) "tut2"
3) "tutorial 2"
4) "tut4"
* lpop tutorials
"tut3"
* lrange tutorials 0 3
1) "tut2"
2) "tutorial 2"
3) "tut4"
* rpop tutorials
"tut4"
* lpush numbers 1 2 3 4
(integer) 4
* lrange numbers 0 3
1) "4"
2) "3"
3) "2"
4) "1"
* ltrim numbers 1 2
lrange numbers 0 3
1) "3"
2) "2"

* sets
* sadd emails email1 email2 email3
(integer) 3
* smembers emails
1) "email3"
2) "email1"
3) "email2"
* scard emails ----- number of elements
(integer) 3
* sdiff emails newemails
1) "email1"
2) "email2"
* sdiff newmails emails
(empty list or set)
* sdiff newemails emails
1) "email4"
2) "email5"
* sunion emails newemails
1) "email4"
2) "email3"
3) "email1"
4) "email2"
5) "email5"
* sinter emails newemails
1) "email3"
* spop emails
1) "emails1"
* srem newemails email5 email4
(integer) 2

* Ordered Set

* zadd names 10 bassem 20 ali 30 chuck
(integer) 3
* zrange names 0 -1
1) "bassem"
2) "ali"
3) "chuck"
* zcard names
(integer) 3
* zrange names 0 -1 withscores
1) "bassem"
2) "10"
3) "ali"
4) "20"
5) "chuck"
6) "30"
* zrange names 1 2 withscores
1) "ali"
2) "20"
3) "chuck"
4) "30"
* zcount names -inf +inf
(integer) 3
* zrank names bassem
(integer) 0
* zrank names chuck
(integer) 2
* zscore names bassem
"10"
* zrem names bassem
(integer) 1
* hset student name bassem
(integer) 1
* hget student name
"bassem"
* hmset student name bassem gender male grade A
OK
*  hmget student name gender and grade 
1) "bassem"
2) "male"
3) (nil)
4) "A"
* hgetall student
1) "name"
2) "bassem"
3) "gender"
4) "male"
5) "grade"
6) "A"
* hexists student name
(integer) 1
* hkeys student
1) "name"
2) "gender"
3) "grade"
* hvals student
1) "bassem"
2) "male"
3) "A"
* hdel student grade
(integer) 1
* hkeys students
1) "name"
2) "gender"
* hlen students
(integer) 2
* save ---- for backup
* transaction
* multi
OK
* set num 10
QUEUED
* incrby num 10
QUEUED
* exec
1) OK
2) (integer) 20
* multi
OK
* set num 10
QUEUED
* incrby num 10
QUEUED
* discard
OK
* get num
"20"
* watch num
OK
* get num
"20"
* multi
OK
* decrby num 7
QUEUED
* set num 5
QUEUED
*  exec
1) (integer) 13
2) OK




























