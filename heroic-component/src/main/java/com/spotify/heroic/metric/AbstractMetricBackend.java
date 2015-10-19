package com.spotify.heroic.metric;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.spotify.heroic.common.Statistics;

import eu.toolchain.async.AsyncFramework;
import eu.toolchain.async.AsyncFuture;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractMetricBackend implements MetricBackend {
    private final AsyncFramework async;

    @Override
    public Statistics getStatistics() {
        return Statistics.empty();
    }

    @Override
    public AsyncFuture<List<String>> serializeKeyToHex(BackendKey key) {
        return async.resolved(ImmutableList.of());
    }

    @Override
    public AsyncFuture<List<BackendKey>> deserializeKeyFromHex(String key) {
        return async.resolved(ImmutableList.of());
    }

    @Override
    public AsyncFuture<BackendKeySet> keys(BackendKey start, int limit, QueryOptions options) {
        return async.resolved(new BackendKeySet());
    }

    @Override
    public AsyncFuture<Void> deleteKey(BackendKey key, QueryOptions options) {
        return async.resolved(null);
    }

    @Override
    public AsyncFuture<Long> countKey(BackendKey key, QueryOptions options) {
        return async.resolved(0L);
    }
}