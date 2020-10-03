import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonsterList {
    private static ArrayList<Monster> monsterList = new ArrayList<Monster>();

    public MonsterList() {
        this.addMonsterToList("イガキン",new Integer(9));
        this.addMonsterToList("ナマチュウ",new Integer(3));
        this.addMonsterToList("イノウエン",new Integer(1));
        this.addMonsterToList("リョージィ",new Integer(2));
        this.addMonsterToList("アキモトン",new Integer(5));
        this.addMonsterToList("ゴージマ",new Integer(4));
        this.addMonsterToList("チュウデン",new Integer(6));
        this.addMonsterToList("ヅカホン",new Integer(8));
        this.addMonsterToList("ニシムラー",new Integer(7));
        this.addMonsterToList("サコーデン",new Integer(2));
        this.addMonsterToList("ウッチー",new Integer(5));
        this.addMonsterToList("ハヤッシー",new Integer(4));
        this.addMonsterToList("キーチー",new Integer(3));
        this.addMonsterToList("リョクン",new Integer(1));
        this.addMonsterToList("デコポン",new Integer(6));
        this.addMonsterToList("カミサン",new Integer(5));
        this.addMonsterToList("シスイ",new Integer(1));
        this.addMonsterToList("ジョナ",new Integer(7));
        this.addMonsterToList("ギダギダ",new Integer(2));
        this.addMonsterToList("ミッツー",new Integer(8));
        this.addMonsterToList("ゾエサン",new Integer(5));
        this.addMonsterToList("キタバー",new Integer(3));
    }

    public Monster randomFromMonsterList() {
        Random random = new Random();
        Integer index = random.nextInt(monsterList.size());
        return monsterList.get(index);
    }

    private void addMonsterToList(String name,Integer rate){
        Monster newMonster = new Monster(name,rate);
        monsterList.add(newMonster);
    }
}