package model.instruments;

import Interface.Instrument;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Instruments
{

    private List<Instrument> instrumentList = new CopyOnWriteArrayList<Instrument>();

    public Instruments()
    {
        this.instrumentList.add(new ExtraSmallDildo());
        this.instrumentList.add(new SmallDildo());
        this.instrumentList.add(new MediumDildo());
        this.instrumentList.add(new LargeDildo());
        this.instrumentList.add(new ExtraLargeDildo());
    }

    public List<Instrument> getInstruments()
    {
        return instrumentList;
    }
}
