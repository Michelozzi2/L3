package reseaux.Td2;

import java.io.IOException;
//import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
//import java.io.OutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.Externalizable;
import java.util.ArrayList;
//import java.util.zip.GZIPInputStream;
//import java.util.zip.GZIPOutputStream;


public class Entity2D implements Externalizable {
    private static final long serialVersionUID = 1L;
    public static final int MAX_ITEMS = 10;
    public static int nb_generated = 0;
    private int id;
    private String name;
    private float x;
    private float y;
    private ArrayList<Integer> items;

    public Entity2D(String name, float x, float y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.id = nb_generated;
        nb_generated++;
        items = new ArrayList<Integer>();
    }

    public Entity2D() {
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject(name);
        out.writeFloat(x);
        out.writeFloat(y);
        out.writeObject(items);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readInt();
        name = (String) in.readObject();
        x = in.readFloat();
        y = in.readFloat();
        //items = (ArrayList<Integer>) in.readObject();
    }


    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public ArrayList<Integer> getItems() {
        return items;
    }

    
    @Override
    public String toString() {
        return "Entity2D [id=" + id + ", name=" + name + ", x=" + x + ", y=" + y + ", items=" + items + "]";
    }

    public void putItem(int item) {
        if (items.size() < MAX_ITEMS) {
            items.add(item);
        } else {
            System.out.println("La limite MAX_ITEMS a été atteinte. Impossible d'ajouter un nouvel élément.");
        }
    }

    public void toBytes(DataOutputStream data) throws IOException {
        data.writeShort(id);
        data.writeUTF(name);
        data.writeFloat(x);
        data.writeFloat(y);
        data.writeShort(items.size()); // Écrit la taille de l'ArrayList
        for (int item : items) {
            data.writeShort(item);
        }
    }

    public static Entity2D fromBytes(DataInputStream data) throws IOException {
        Entity2D entity = new Entity2D();
        entity.id = data.readShort();
        entity.name = data.readUTF();
        entity.x = data.readFloat();
        entity.y = data.readFloat();
        int itemCount = data.readShort(); // Lit la taille de l'ArrayList
        entity.items = new ArrayList<>(itemCount);
        for (int i = 0; i < itemCount; i++) {
            entity.items.add((int) data.readShort());
        }
        return entity;
    }
}
