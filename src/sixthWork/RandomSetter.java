package sixthWork;


public class RandomSetter {
    public Train makeNewPassengerTrain() {
        int numOfWagons = (int) Math.round(Math.random() * (40) + 10);
        int nummberOfTrain = (int) Math.round(Math.random() * (300) + 200);

        Train train = new Train(numOfWagons, new Tractor(numOfWagons * 33), "Name Surname ",
                nummberOfTrain, "Kiev - Vein");

        for (int i = 0; i < numOfWagons; i += 4) {
            SV sv = new SV((int) Math.round(Math.random() * (300) + 200));
            SittingCarriage sittingCarriage = new SittingCarriage((int) Math.round(Math.random() * (300) + 200));
            CompartmentCarriage compartmentCarriage = new CompartmentCarriage((int) Math.round(Math.random() * (300) + 200));
            PlaceCarriageCar placeCarriageCar = new PlaceCarriageCar((int) Math.round(Math.random() * (300) + 200));

            for (int j = 0; j < (int) Math.round(Math.random() * (10) + 10); j++) {
                if (sv.addPassanger(" ", " ", (int) Math.round(Math.random() * (100) + 100),
                        (int) Math.round(Math.random() * (4)), (int) Math.round(Math.random() * (20))) == -1) {
                    sv.addPassanger(" ", " ", (int) Math.round(Math.random() * (100) + 100),
                            (int) Math.round(Math.random() * (4)), (int) Math.round(Math.random() * (20)));
                }
            }

            for (int j = 0; j < (int) Math.round(Math.random() * (30) + 30); j++) {
                if (sittingCarriage.addPassanger(" ", " ", (int) Math.round(Math.random() * (100) + 100),
                        (int) Math.round(Math.random()), (int) Math.round(Math.random() * (60))) == -1) {
                    sittingCarriage.addPassanger(" ", " ", (int) Math.round(Math.random() * (100) + 100),
                            (int) Math.round(Math.random()), (int) Math.round(Math.random() * (60)));
                }
            }

            for (int j = 0; j < (int) Math.round(Math.random() * (20) + 20); j++) {
                if (compartmentCarriage.addPassanger(" ", " ", (int) Math.round(Math.random() * (100) + 100),
                        (int) Math.round(Math.random() * (3)), (int) Math.round(Math.random() * (40))) == -1) {
                    compartmentCarriage.addPassanger(" ", " ", (int) Math.round(Math.random() * (100) + 100),
                            (int) Math.round(Math.random() * (3)), (int) Math.round(Math.random() * (40)));
                }

            }

            for (int j = 0; j < (int) Math.round(Math.random() * (27) + 27); j++) {
                if (placeCarriageCar.addPassanger(" ", " ", (int) Math.round(Math.random() * (100) + 100),
                        (int) Math.round(Math.random() * (2)), (int) Math.round(Math.random() * (54))) == 1) {
                    placeCarriageCar.addPassanger(" ", " ", (int) Math.round(Math.random() * (100) + 100),
                            (int) Math.round(Math.random() * (2)), (int) Math.round(Math.random() * (54)));
                }
            }

            if (!train.addInTheSpace(i, sv) |
                    !train.addInTheSpace(i + 1, sittingCarriage) |
                    !train.addInTheSpace(i + 2, compartmentCarriage) |
                    !train.addInTheSpace(i + 3, placeCarriageCar)) {
                System.out.println("We have a problem with adding");
            }

        }

        return train;
    }
}
