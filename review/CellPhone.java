class CellPhone {
    CellPhone() {
        // Constructor của CellPhone
    }

    public void ring(Tune t) {
        t.play();
    }
}

class Tune {
    public void play() {
        System.out.println("Tune.play()");
    }
}

class ObnoxiousTune extends Tune {
    ObnoxiousTune() {
        System.out.println("ObnoxiousTune.play()");
    }
}
