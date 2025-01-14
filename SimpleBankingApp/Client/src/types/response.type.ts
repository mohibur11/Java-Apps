export type SuccessResponse<T> = { status: "success"; data: T };
export type FailedResponse<U> = { status: "error"; message: string, data: U };

export type AsyncResponse<T, U> = SuccessResponse<T> | FailedResponse<U>;
