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



