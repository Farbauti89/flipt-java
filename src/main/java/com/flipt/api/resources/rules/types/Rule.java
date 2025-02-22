package com.flipt.api.resources.rules.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.flipt.api.resources.distributions.types.Distribution;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Rule.Builder.class)
public final class Rule {
    private final String id;

    private final String namespaceKey;

    private final String flagKey;

    private final String segmentKey;

    private final Optional<List<String>> segmentKeys;

    private final RuleSegmentOperator segmentOperator;

    private final List<Distribution> distributions;

    private final int rank;

    private final OffsetDateTime createdAt;

    private final OffsetDateTime updatedAt;

    private Rule(
            String id,
            String namespaceKey,
            String flagKey,
            String segmentKey,
            Optional<List<String>> segmentKeys,
            RuleSegmentOperator segmentOperator,
            List<Distribution> distributions,
            int rank,
            OffsetDateTime createdAt,
            OffsetDateTime updatedAt) {
        this.id = id;
        this.namespaceKey = namespaceKey;
        this.flagKey = flagKey;
        this.segmentKey = segmentKey;
        this.segmentKeys = segmentKeys;
        this.segmentOperator = segmentOperator;
        this.distributions = distributions;
        this.rank = rank;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("namespaceKey")
    public String getNamespaceKey() {
        return namespaceKey;
    }

    @JsonProperty("flagKey")
    public String getFlagKey() {
        return flagKey;
    }

    @JsonProperty("segmentKey")
    public String getSegmentKey() {
        return segmentKey;
    }

    @JsonProperty("segmentKeys")
    public Optional<List<String>> getSegmentKeys() {
        return segmentKeys;
    }

    @JsonProperty("segmentOperator")
    public RuleSegmentOperator getSegmentOperator() {
        return segmentOperator;
    }

    @JsonProperty("distributions")
    public List<Distribution> getDistributions() {
        return distributions;
    }

    @JsonProperty("rank")
    public int getRank() {
        return rank;
    }

    @JsonProperty("createdAt")
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("updatedAt")
    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Rule && equalTo((Rule) other);
    }

    private boolean equalTo(Rule other) {
        return id.equals(other.id)
                && namespaceKey.equals(other.namespaceKey)
                && flagKey.equals(other.flagKey)
                && segmentKey.equals(other.segmentKey)
                && segmentKeys.equals(other.segmentKeys)
                && segmentOperator.equals(other.segmentOperator)
                && distributions.equals(other.distributions)
                && rank == other.rank
                && createdAt.equals(other.createdAt)
                && updatedAt.equals(other.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.namespaceKey,
                this.flagKey,
                this.segmentKey,
                this.segmentKeys,
                this.segmentOperator,
                this.distributions,
                this.rank,
                this.createdAt,
                this.updatedAt);
    }

    @Override
    public String toString() {
        return "Rule{" + "id: " + id + ", namespaceKey: " + namespaceKey + ", flagKey: " + flagKey + ", segmentKey: "
                + segmentKey + ", segmentKeys: " + segmentKeys + ", segmentOperator: " + segmentOperator
                + ", distributions: " + distributions + ", rank: " + rank + ", createdAt: " + createdAt
                + ", updatedAt: " + updatedAt + "}";
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        NamespaceKeyStage id(String id);

        Builder from(Rule other);
    }

    public interface NamespaceKeyStage {
        FlagKeyStage namespaceKey(String namespaceKey);
    }

    public interface FlagKeyStage {
        SegmentKeyStage flagKey(String flagKey);
    }

    public interface SegmentKeyStage {
        SegmentOperatorStage segmentKey(String segmentKey);
    }

    public interface SegmentOperatorStage {
        RankStage segmentOperator(RuleSegmentOperator segmentOperator);
    }

    public interface RankStage {
        CreatedAtStage rank(int rank);
    }

    public interface CreatedAtStage {
        UpdatedAtStage createdAt(OffsetDateTime createdAt);
    }

    public interface UpdatedAtStage {
        _FinalStage updatedAt(OffsetDateTime updatedAt);
    }

    public interface _FinalStage {
        Rule build();

        _FinalStage segmentKeys(Optional<List<String>> segmentKeys);

        _FinalStage segmentKeys(List<String> segmentKeys);

        _FinalStage distributions(List<Distribution> distributions);

        _FinalStage addDistributions(Distribution distributions);

        _FinalStage addAllDistributions(List<Distribution> distributions);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements IdStage,
                    NamespaceKeyStage,
                    FlagKeyStage,
                    SegmentKeyStage,
                    SegmentOperatorStage,
                    RankStage,
                    CreatedAtStage,
                    UpdatedAtStage,
                    _FinalStage {
        private String id;

        private String namespaceKey;

        private String flagKey;

        private String segmentKey;

        private RuleSegmentOperator segmentOperator;

        private int rank;

        private OffsetDateTime createdAt;

        private OffsetDateTime updatedAt;

        private List<Distribution> distributions = new ArrayList<>();

        private Optional<List<String>> segmentKeys = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(Rule other) {
            id(other.getId());
            namespaceKey(other.getNamespaceKey());
            flagKey(other.getFlagKey());
            segmentKey(other.getSegmentKey());
            segmentKeys(other.getSegmentKeys());
            segmentOperator(other.getSegmentOperator());
            distributions(other.getDistributions());
            rank(other.getRank());
            createdAt(other.getCreatedAt());
            updatedAt(other.getUpdatedAt());
            return this;
        }

        @Override
        @JsonSetter("id")
        public NamespaceKeyStage id(String id) {
            this.id = id;
            return this;
        }

        @Override
        @JsonSetter("namespaceKey")
        public FlagKeyStage namespaceKey(String namespaceKey) {
            this.namespaceKey = namespaceKey;
            return this;
        }

        @Override
        @JsonSetter("flagKey")
        public SegmentKeyStage flagKey(String flagKey) {
            this.flagKey = flagKey;
            return this;
        }

        @Override
        @JsonSetter("segmentKey")
        public SegmentOperatorStage segmentKey(String segmentKey) {
            this.segmentKey = segmentKey;
            return this;
        }

        @Override
        @JsonSetter("segmentOperator")
        public RankStage segmentOperator(RuleSegmentOperator segmentOperator) {
            this.segmentOperator = segmentOperator;
            return this;
        }

        @Override
        @JsonSetter("rank")
        public CreatedAtStage rank(int rank) {
            this.rank = rank;
            return this;
        }

        @Override
        @JsonSetter("createdAt")
        public UpdatedAtStage createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @Override
        @JsonSetter("updatedAt")
        public _FinalStage updatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        @Override
        public _FinalStage addAllDistributions(List<Distribution> distributions) {
            this.distributions.addAll(distributions);
            return this;
        }

        @Override
        public _FinalStage addDistributions(Distribution distributions) {
            this.distributions.add(distributions);
            return this;
        }

        @Override
        @JsonSetter(value = "distributions", nulls = Nulls.SKIP)
        public _FinalStage distributions(List<Distribution> distributions) {
            this.distributions.clear();
            this.distributions.addAll(distributions);
            return this;
        }

        @Override
        public _FinalStage segmentKeys(List<String> segmentKeys) {
            this.segmentKeys = Optional.of(segmentKeys);
            return this;
        }

        @Override
        @JsonSetter(value = "segmentKeys", nulls = Nulls.SKIP)
        public _FinalStage segmentKeys(Optional<List<String>> segmentKeys) {
            this.segmentKeys = segmentKeys;
            return this;
        }

        @Override
        public Rule build() {
            return new Rule(
                    id,
                    namespaceKey,
                    flagKey,
                    segmentKey,
                    segmentKeys,
                    segmentOperator,
                    distributions,
                    rank,
                    createdAt,
                    updatedAt);
        }
    }
}
