package main.model.vehicle;

public enum CarBrand {
    Mercedes,
    Opel,
    BMW,
    FIAT,
    Volvo,
    Volkswagen,
    Renault,
    Ford,
    Peugeot,
    Skoda,
    KIA,
    Audi,
    Toyota,
    Citroen,
    Hyundai,
    Seat,
    Nissan,
    Mazda,
    Jeep,
    Honda,
    Tesla,
    Lamborghini,
    Porsche,
    Mitsubishi;

    public boolean isExpensiveBrand (Car car){
        CarBrand [] expensiveBrands = {Mercedes, BMW, Volvo, Tesla, Lamborghini,Porsche};
        for (CarBrand expensiveBrand: expensiveBrands){
            if (car.getBrand() == expensiveBrand){
                return true;
            }
        }
        return false;
    }

    public boolean isAverageBrand(Car car){
        CarBrand [] averageBrands = {Audi, Volkswagen, Toyota, Nissan, Mazda, Jeep, Mitsubishi};
        for (CarBrand averageBrand: averageBrands){
            if (car.getBrand() == averageBrand){
                return true;
            }
        }
        return false;
    }

}
