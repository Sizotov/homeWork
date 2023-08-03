package homeWork.family_tree;

import homeWork.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private long humansId;

    private final List<Human> humanList;
    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }
    public FamilyTree(){
        this(new ArrayList<>());
    }
    public void add(Human human){
        if(human == null){
            return;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChildren(human);

        }
    }
    private void addToParents(Human human){
        for(Human parent: human.getParents()){
            parent.addChild(human);
        }
    }
    private void addToChildren(Human human){
        for(Human child: human.getChildren()){
            child.addParent(human);
        }
    }
    public List<Human>getSiblings(long id){
        Human human = getById(id);
        if (human == null){
            return null;
        }
        List<Human> res = new ArrayList<>();
        for(Human parent: human.getParents()){
            for (Human child: parent.getChildren()){
                if (!child.equals(human)){
                    res.add(child);
                }
            }
        }
        return res;
    }
    public void setWedding(long humansId1, long humansId2){
        if (checkId(humansId1) && checkId(humansId2)){
            Human human1 = getById(humansId1);
            Human human2 = getById(humansId2);
            if (human1.getSpouse() == null && human2.getSpouse() == null){
                human1.setSpouse(human2);
                human2.setSpouse(human1);
            }
        }
    }
    private boolean checkId(long id){
        if (id >= humansId || id < 0){
            return false;
        }
        for (Human human: humanList){
            if (human.getId() == id){
                return true;
            }
        }
        return false;
    }

    public Human getById(long id){
        for (Human human: humanList){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for(Human human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
    @Override
    public String toString() {return getInfo();}

    @Override
    public Iterator<Human> iterator() { return new FamilyTreeIterator(humanList);}
    public void sortByName() {humanList.sort(new HumanComparatorByName());}
    public void sortByBirthDate() {humanList.sort(new HumanComparatorByBirthDate());}
}

