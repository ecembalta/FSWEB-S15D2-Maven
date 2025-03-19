package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String name){
        switch (name.toLowerCase()){
            case "ann":
                return new HashSet<>(annsTasks);
            case "bob":
                return new HashSet<>(bobsTasks);
            case "carol":
                return new HashSet<>(carolsTasks);
            case "all":
                Set<Task> allTasks = new HashSet<>();
                allTasks.addAll(annsTasks);
                allTasks.addAll(bobsTasks);
                allTasks.addAll(carolsTasks);
                allTasks.addAll(unassignedTasks);
                return allTasks;
            default:
                System.out.println("Geçersiz görev sahibi: " + name);
                return new HashSet<>();
        }
    }

    public Set<Task> getUnion(Set<Task>...sets){
        Set<Task> union = new HashSet<>();
        for(Set<Task> set: sets){
            union.addAll(set);
        }
        return union;
    }

    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2){
        Set<Task> set1Copy = new HashSet<>(set1);
        set1Copy.retainAll(set2);
        return set1Copy;
    }

    public Set<Task> getDifferences(Set<Task> set1, Set<Task> set2){
        Set<Task> set1Copy = new HashSet<>(set1);
        set1Copy.removeAll(set2);
        return set1Copy;
    }

    @Override
    public String toString() {
        return "TaskData{" +
                "annsTasks=" + annsTasks +
                ", bobsTasks=" + bobsTasks +
                ", carolsTasks=" + carolsTasks +
                ", unassignedTasks=" + unassignedTasks +
                '}';
    }
}
