import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class MonsterList {
    private static ArrayList<Monster> monsterList = new ArrayList<Monster>();

    public MonsterList() {
        init();
    }

    public static void init() {
        addMonsterToList("イガキン",new Integer(9));
        addMonsterToList("ナマチュウ",new Integer(3));
        addMonsterToList("イノウエン",new Integer(1));
        addMonsterToList("リョージィ",new Integer(2));
        addMonsterToList("アキモトン",new Integer(5));
        addMonsterToList("ゴージマ",new Integer(4));
        addMonsterToList("チュウデン",new Integer(6));
        addMonsterToList("ヅカホン",new Integer(8));
        addMonsterToList("ニシムラー",new Integer(7));
        addMonsterToList("サコーデン",new Integer(2));
        addMonsterToList("ウッチー",new Integer(5));
        addMonsterToList("ハヤッシー",new Integer(4));
        addMonsterToList("キーチー",new Integer(3));
        addMonsterToList("リョクン",new Integer(1));
        addMonsterToList("デコポン",new Integer(6));
        addMonsterToList("カミサン",new Integer(5));
        addMonsterToList("シスイ",new Integer(1));
        addMonsterToList("ジョナ",new Integer(7));
        addMonsterToList("ギダギダ",new Integer(2));
        addMonsterToList("ミッツー",new Integer(8));
        addMonsterToList("ゾエサン",new Integer(5));
        addMonsterToList("キタバー",new Integer(3));
    }

    public static Monster randomFromMonsterList() {
        Random random = new Random();
        Integer listSize = monsterList.size();
        Integer index = random.nextInt(listSize);
        return monsterList.get(index);
    }

    private static void addMonsterToList(String name,Integer rate){
        Monster newMonster = new Monster(name,rate);
        monsterList.add(newMonster);
    }
}