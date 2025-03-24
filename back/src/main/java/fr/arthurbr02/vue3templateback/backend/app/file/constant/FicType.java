package fr.arthurbr02.vue3templateback.backend.app.file.constant;

public enum FicType {
    PROFILE_PICTURE("profile_picture");

    private String name;

    FicType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
