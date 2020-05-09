package com.milunas.alchemix.common;

import java.util.Optional;

public class Result<T>
{
    private final boolean isSuccessful;
    private final T holding;
    private final Optional<Throwable> reason;

    public Result(boolean isSuccessful, T holding, Optional<Throwable> reason) {
        this.isSuccessful = isSuccessful;
        this.holding = holding;
        this.reason = reason;
    }

    public static <T> Result<T> success(T holding) {
        return new Result<>(true, holding, Optional.empty());
    }

    public static <T> Result<T> failure() {
        return new Result<>(false, null, Optional.empty());
    }

    public static Result<Throwable> failure(Throwable t) {
        return new Result<>(false, null, Optional.of(t));
    }

    public boolean isSuccessful()
    {
        return isSuccessful;
    }

    public boolean isFailure() { return !isSuccessful; }
}
