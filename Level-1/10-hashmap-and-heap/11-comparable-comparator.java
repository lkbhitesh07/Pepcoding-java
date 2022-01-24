import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue<T> {
    ArrayList<T> data;
    Comparator comp;

    public PriorityQueue() {
      data = new ArrayList<T>();
      comp = null;
    }

    public PriorityQueue(Comparator comp) {
      data = new ArrayList<T>();
      this.comp = comp;
    }

    // Detailed discussion on HEAP, take a look to understand well. - https://www.pepcoding.com/resources/online-java-foundation/hashmap-and-heap/priority_queue_using_heap/topic

    public boolean isSmaller(int i, int j) {
      if (comp == null) {
        Comparable ith = (Comparable) data.get(i);
        Comparable jth = (Comparable) data.get(j);

        if (ith.compareTo(jth) < 0) {
          return true;
        } else {
          return false;
        }
      } else {
        T ith = data.get(i);
        T jth = data.get(j);

        if (comp.compare(ith, jth) < 0)
        {
          return true;
        }
        else
        {
          return false;
        }
      }
    }

    public void add(T val) {
      // write your code here
      data.add(val);
      upheapify(data.size() - 1);
    }

    private void upheapify(int child_index) {
      if (child_index == 0) {
        return;
      }

      int parent_index = (child_index - 1) / 2;

      if (isSmaller(child_index, parent_index)) {
        swap(parent_index, child_index);
        upheapify(parent_index);
      }
    }

    private void swap(int pi, int ci) {
      T p = data.get(pi);
      T c = data.get(ci);

      data.set(pi, c);
      data.set(ci, p);
    }

    public T remove() {
      // write your code here
      if (this.size() == 0) {
        System.out.println("Underflow");
        return null;
      }

      swap(0, data.size() - 1);
      T val = data.remove(data.size() - 1);
      downheapify(0);
      return val;
    }

    private void downheapify(int pi) {
      int min = pi;

      int li = 2 * pi + 1;
      if (li < data.size() && isSmaller(li, min)) {
        min = li;
      }

      int ri = 2 * pi + 2;
      if (ri < data.size() && isSmaller(ri, min)) {
        min = ri;
      }

      if (pi != min) {
        swap(pi, min);
        downheapify(min);
      }
    }

    public T peek() {
      // write your code here
      if (this.size() == 0) {
        System.out.println("Underflow");
        return null;
      }

      return data.get(0);
    }

    public int size() {
      // write your code here
      return data.size();
    }
  }

  public static class Student implements Comparable<Student> {
    int rNo;
    int ht;
    int wt;

    Student(int rNo, int ht, int wt) {
      this.rNo = rNo;
      this.ht = ht;
      this.wt = wt;
    }

    public int compareTo(Student other) {
      return this.rNo - other.rNo;
    }

    public String toString() {
      return "rno= " + rNo + "height= " + ht + "weight= " + wt;
    }
  }

  static class StudentHtComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
      return s1.ht - s2.ht;
    }
  }

  static class StudentWtComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
      return s1.wt - s2.wt;
    }
  }

  public static void main(String[] args) {

    PriorityQueue<Student> pq = new PriorityQueue<>(new StudentHtComparator());

    pq.add(new Student(1, 480, 70));
    pq.add(new Student(5, 580, 80));
    pq.add(new Student(3, 180, 90));
    pq.add(new Student(2, 380, 60));
    pq.add(new Student(6, 280, 40));

    while (pq.size() != 0) {
      System.out.println(pq.peek());
      pq.remove();
    }
  }
}







// import java.util.*;
// import java.io.*;

// public class Main {
    
//     public static class Student implements Comparable<Student> {
//         int rNo;
//         int ht;
//         int wt;
        
//         Student(int rNo, int ht, int wt) {
//             this.rNo = rNo;
//             this.ht = ht;
//             this.wt = wt;
//         }
        
//         public int compareTo(Student other) {
//             return this.rNo - other.rNo;
//         }
        
//         public String toString() {
//             return "rno= " + rNo + "height= " + ht + "weight= " + wt;
//         }
//     }
    
//     static class StudentHtComparator implements Comparator<Student> {
//         public int compare(Student s1, Student s2) {
//             return s1.ht-s2.ht;
//         }
//     }
    
//     static class StudentWtComparator implements Comparator<Student> {
//         public int compare(Student s1, Student s2) {
//             return s1.wt-s2.wt;
//         }
//     }
    
//     public static void main(String[] args) {
        
//         PriorityQueue<Student> pq = new PriorityQueue<>(new StudentHtComparator()); // This is the work of comparator, if you want to compare other than by default comparison.
        
//         pq.add(new Student(1, 480, 70));
//         pq.add(new Student(5, 580, 80));
//         pq.add(new Student(3, 180, 90));
//         pq.add(new Student(2, 380, 60));
//         pq.add(new Student(6, 280, 40));
        
//         while(pq.size() != 0) {
//             System.out.println(pq.peek());
//             pq.remove();
//         }
//     }
// }
