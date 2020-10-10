# リファクタリングの結果
リファクタリング後、9rulesを用いて評価を行った。
以下はそれぞれのレベルで実行した結果となる。

## rough
@ src $ docker run --rm -v $PWD:/home/ninerules tamada/9rules ./ --rough
./Bag.java
line: 10,11,13, field count is more than 4.
./Balls.java
./BattleEvent.java
./Distance.java
./Egg.java
./Eggs.java
./Event.java
./Events.java
./Fruits.java
./Main.java
./Monster.java
./MonsterList.java
line: 12, method is too long (over 10 lines).
./MonsterZoo.java
./Name.java
./Player.java
line: 6,7,10, not first class collection.
./Rare.java
./StationEvent.java
9rules found 3 violations in 3 files.

## general
@ src $ docker run --rm -v $PWD:/home/ninerules tamada/9rules ./ --general
./Bag.java
line: 10,11,13, field count is more than 3.
./Balls.java
./BattleEvent.java
./Distance.java
./Egg.java
./Eggs.java
./Event.java
./Events.java
./Fruits.java
./Main.java
./Monster.java
./MonsterList.java
line: 12, method is too long (over 5 lines).
./MonsterZoo.java
./Name.java
./Player.java
line: 6,7,10, not first class collection.
./Rare.java
./StationEvent.java
9rules found 3 violations in 3 files.

## strict
@ src $ docker run --rm -v $PWD:/home/ninerules tamada/9rules ./ --strict
./Bag.java
line: 10,11,13, field count is more than 2.
line: 62, source code is too long (over 50 lines).
./Balls.java
line: 25, many dots per line (more than 1 dots).
./BattleEvent.java
line: 20, many dots per line (more than 1 dots).
./Distance.java
line: 12, many dots per line (more than 1 dots).
./Egg.java
line: 14, many dots per line (more than 1 dots).
./Eggs.java
line: 18, many dots per line (more than 1 dots).
line: 32, many dots per line (more than 1 dots).
line: 38, many dots per line (more than 1 dots).
./Event.java
./Events.java
./Fruits.java
./Main.java
line: 9, method is too long (over 3 lines).
./Monster.java
line: 17, many dots per line (more than 1 dots).
line: 21, many dots per line (more than 1 dots).
line: 25, many dots per line (more than 1 dots).
line: 29, many dots per line (more than 1 dots).
line: 33, many dots per line (more than 1 dots).
./MonsterList.java
line: 12, method is too long (over 3 lines).
line: 37, method is too long (over 3 lines).
./MonsterZoo.java
line: 35, many dots per line (more than 1 dots).
./Name.java
./Player.java
line: 6,7,10, not first class collection.
line: 59, many dots per line (more than 1 dots).
line: 60, source code is too long (over 50 lines).
./Rare.java
./StationEvent.java
9rules found 21 violations in 11 files.