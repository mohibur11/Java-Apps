import axios from "axios";
import { Account } from "../types/account.type";
import { AsyncResponse } from "../types/response.type";
const https = axios.create({
  baseURL: "http://localhost:8080/simple-banking",
  // headers: {'X-Custom-Header': 'foobar'}
});

export async function getAccount(
  id: string
): Promise<AsyncResponse<Account, unknown>> {
  try {
    const params = { id };
    const resp = await https.get("/account", {
      params,
    });
    return { status: "success", data: resp.data };
  } catch (error) {
    return {
      status: "error",
      message: "Error Occured during getBalance call",
      data: error,
    };
  }
}

export async function depositBalance(
  id: string, amount: number
): Promise<AsyncResponse<Account, unknown>> {
  try {
    const params = { id, amount };
    const resp = await https.get("/account", {
      params,
    });
    return { status: "success", data: resp.data };
  } catch (error) {
    return {
      status: "error",
      message: "Error Occured during deposit Balance",
      data: error,
    };
  }
}

export async function widthdrawBalance(
  id: string, amount: number
): Promise<AsyncResponse<Account, unknown>> {
  try {
    const params = { id, amount };
    const resp = await https.get("/api/withdraw", {
      params,
    });
    return { status: "success", data: resp.data };
  } catch (error) {
    return {
      status: "error",
      message: "Error Occured during withdrawBalance",
      data: error,
    };
  }
}

export async function createAccount(
  account: Account
): Promise<AsyncResponse<Account, unknown>> {
  try {
    const resp = await https.post("/account/createAccount", account);
    return { status: "success", data: resp.data };
  } catch (error) {
    return {
      status: "error",
      message: "Error Occured during create Account",
      data: error,
    };
  }
}