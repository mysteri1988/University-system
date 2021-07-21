package com.foxminded.university.domain;

public class ClassRoom {

    private int id;
    private int roomNumber;
    private int buildingNumber;

    public ClassRoom() {
    };

    public ClassRoom(int roomNumber, int buildingNumber) {
        this.roomNumber = roomNumber;
        this.buildingNumber = buildingNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + buildingNumber;
        result = prime * result + roomNumber;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ClassRoom)) {
            return false;
        }
        ClassRoom other = (ClassRoom) obj;
        if (buildingNumber != other.buildingNumber) {
            return false;
        }
        if (roomNumber != other.roomNumber) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClassRoom [id=" + id + ", roomNumber=" + roomNumber + ", buildingNumber=" + buildingNumber + "]";
    }

}
