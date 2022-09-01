package com.keystone.coinlib.coins.polkadot.pallets.staking;

import com.keystone.coinlib.coins.polkadot.UOS.Network;
import com.keystone.coinlib.coins.polkadot.pallets.EmptyParameter;
import com.keystone.coinlib.coins.polkadot.pallets.Pallet;
import com.keystone.coinlib.coins.polkadot.scale.ScaleCodecReader;

public class ForceNewEra extends Pallet<EmptyParameter> {
    public ForceNewEra(Network network, int code) {
        super("staking.forceNewEras", network, code);
    }

    @Override
    public EmptyParameter read(ScaleCodecReader scr) {
        return new EmptyParameter(name, network, code, scr);
    }
}
