package subconjuntos;

import java.util.ArrayList;
import java.util.List;

public class SubSetFinder {

    private int[] set;
    private int subSetLength;
    private List<List<Integer>> result;

    public List<List<Integer>> findSubsets(int[] set, int m) {
        this.set = set;
        this.subSetLength = m;
        this.result = new ArrayList<>();
        List<Integer> internalSubset = new ArrayList<>();
        backtrack(0, internalSubset);
        return result;
    }

    private void backtrack(int start, List<Integer> _internalSubset) {
        if (_internalSubset.size() == subSetLength) {
            List<Integer> subsetFound = new ArrayList<>(_internalSubset);
            result.add(subsetFound);
            return;
        }
        int needed = subSetLength - _internalSubset.size();
        int remaining = set.length - start;
        if (remaining < needed) {
            return;
        }
        for (int i = start; i < set.length; i++) {
            _internalSubset.add(set[i]);
            backtrack(i + 1, _internalSubset);
            _internalSubset.remove(_internalSubset.size() - 1);
        }
    }

    @Override
    public String toString() {
        String _string = "conjunto: ";
        for (int i : set) {
            _string += i + " ";
        }
        _string += "\nsubconjuntos de n = " + subSetLength + ":\n";
        for (List<Integer> subset : this.result) {
            _string += subset.toString() + "\n";
        }
        return _string;
    }

}
