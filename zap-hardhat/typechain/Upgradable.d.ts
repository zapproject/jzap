/* Autogenerated file. Do not edit manually. */
/* tslint:disable */
/* eslint-disable */

import {
  ethers,
  EventFilter,
  Signer,
  BigNumber,
  BigNumberish,
  PopulatedTransaction,
} from "ethers";
import {
  Contract,
  ContractTransaction,
  Overrides,
  CallOverrides,
} from "@ethersproject/contracts";
import { BytesLike } from "@ethersproject/bytes";
import { Listener, Provider } from "@ethersproject/providers";
import { FunctionFragment, EventFragment, Result } from "@ethersproject/abi";

interface UpgradableInterface extends ethers.utils.Interface {
  functions: {
    "updateDependencies()": FunctionFragment;
  };

  encodeFunctionData(
    functionFragment: "updateDependencies",
    values?: undefined
  ): string;

  decodeFunctionResult(
    functionFragment: "updateDependencies",
    data: BytesLike
  ): Result;

  events: {};
}

export class Upgradable extends Contract {
  connect(signerOrProvider: Signer | Provider | string): this;
  attach(addressOrName: string): this;
  deployed(): Promise<this>;

  on(event: EventFilter | string, listener: Listener): this;
  once(event: EventFilter | string, listener: Listener): this;
  addListener(eventName: EventFilter | string, listener: Listener): this;
  removeAllListeners(eventName: EventFilter | string): this;
  removeListener(eventName: any, listener: Listener): this;

  interface: UpgradableInterface;

  functions: {
    updateDependencies(overrides?: Overrides): Promise<ContractTransaction>;

    "updateDependencies()"(overrides?: Overrides): Promise<ContractTransaction>;
  };

  updateDependencies(overrides?: Overrides): Promise<ContractTransaction>;

  "updateDependencies()"(overrides?: Overrides): Promise<ContractTransaction>;

  callStatic: {
    updateDependencies(overrides?: CallOverrides): Promise<void>;

    "updateDependencies()"(overrides?: CallOverrides): Promise<void>;
  };

  filters: {};

  estimateGas: {
    updateDependencies(overrides?: Overrides): Promise<BigNumber>;

    "updateDependencies()"(overrides?: Overrides): Promise<BigNumber>;
  };

  populateTransaction: {
    updateDependencies(overrides?: Overrides): Promise<PopulatedTransaction>;

    "updateDependencies()"(
      overrides?: Overrides
    ): Promise<PopulatedTransaction>;
  };
}
