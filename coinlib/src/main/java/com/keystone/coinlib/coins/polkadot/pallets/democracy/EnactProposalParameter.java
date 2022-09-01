package com.keystone.coinlib.coins.polkadot.pallets.democracy;

import com.keystone.coinlib.coins.polkadot.UOS.Network;
import com.keystone.coinlib.coins.polkadot.pallets.Parameter;
import com.keystone.coinlib.coins.polkadot.scale.ScaleCodecReader;
import com.keystone.coinlib.coins.polkadot.scale.ScaleCodecWriter;

import org.bouncycastle.util.encoders.Hex;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class EnactProposalParameter extends Parameter {
    private byte[] proposalHash;
    private long index;

    public EnactProposalParameter(String name, Network network, int code, ScaleCodecReader scr) {
        super(name, network, code, scr);
    }

    @Override
    protected void write(ScaleCodecWriter scw) throws IOException {
        scw.writeByteArray(proposalHash);
        scw.writeUint32(index);
    }

    @Override
    protected void read(ScaleCodecReader scr) {
        proposalHash = scr.readByteArray(32);
        index = scr.readUint32();
    }

    @Override
    protected JSONObject addCallParameter() throws JSONException {
        return new JSONObject().put("ProposalHash", Hex.toHexString(proposalHash))
                .put("Index", index);
    }
}
