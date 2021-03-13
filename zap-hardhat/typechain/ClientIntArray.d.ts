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

interface ClientIntArrayInterface extends ethers.utils.Interface {
  functions: {
    "callback(uint256,int256[])": FunctionFragment;
  };

  encodeFunctionData(
    functionFragment: "callback",
    values: [BigNumberish, BigNumberish[]]
  ): string;

  decodeFunctionResult(functionFragment: "callback", data: BytesLike): Result;

  events: {};
}

export class ClientIntArray extends Contract {
  connect(signerOrProvider: Signer | Provider | string): this;
  attach(addressOrName: string): this;
  deployed(): Promise<this>;

  on(event: EventFilter | string, listener: Listener): this;
  once(event: EventFilter | string, listener: Listener): this;
  addListener(eventName: EventFilter | string, listener: Listener): this;
  removeAllListeners(eventName: EventFilter | string): this;
  removeListener(eventName: any, listener: Listener): this;

  interface: ClientIntArrayInterface;

  functions: {
    callback(
      id: BigNumberish,
      response: BigNumberish[],
      overrides?: Overrides
    ): Promise<ContractTransaction>;

    "callback(uint256,int256[])"(
      id: BigNumberish,
      response: BigNumberish[],
      overrides?: Overrides
    ): Promise<ContractTransaction>;
  };

  callback(
    id: BigNumberish,
    response: BigNumberish[],
    overrides?: Overrides
  ): Promise<ContractTransaction>;

  "callback(uint256,int256[])"(
    id: BigNumberish,
    response: BigNumberish[],
    overrides?: Overrides
  ): Promise<ContractTransaction>;

  callStatic: {
    callback(
      id: BigNumberish,
      response: BigNumberish[],
      overrides?: CallOverrides
    ): Promise<void>;

    "callback(uint256,int256[])"(
      id: BigNumberish,
      response: BigNumberish[],
      overrides?: CallOverrides
    ): Promise<void>;
  };

  filters: {};

  estimateGas: {
    callback(
      id: BigNumberish,
      response: BigNumberish[],
      overrides?: Overrides
    ): Promise<BigNumber>;

    "callback(uint256,int256[])"(
      id: BigNumberish,
      response: BigNumberish[],
      overrides?: Overrides
    ): Promise<BigNumber>;
  };

  populateTransaction: {
    callback(
      id: BigNumberish,
      response: BigNumberish[],
      overrides?: Overrides
    ): Promise<PopulatedTransaction>;

    "callback(uint256,int256[])"(
      id: BigNumberish,
      response: BigNumberish[],
      overrides?: Overrides
    ): Promise<PopulatedTransaction>;
  };
}
