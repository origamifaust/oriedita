package oriedita.editor.action;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import oriedita.editor.canvas.CreasePattern_Worker;
import oriedita.editor.service.FoldingService;
import origami.folding.FoldedFigure;

import java.awt.event.ActionEvent;

@ApplicationScoped
@ActionHandler(ActionType.suitei_02Action)
public class Suitei02 extends AbstractOrieditaAction {
    @Inject
    FoldingService foldingService;
    @Inject
    @Named("mainCreasePattern_Worker")
    CreasePattern_Worker mainCreasePatternWorker;

    @Inject
    public Suitei02() {}

    @Override
    public void actionPerformed(ActionEvent e) {
        foldingService.fold(FoldedFigure.EstimationOrder.ORDER_2);//引数の意味は(i_fold_type , i_suitei_meirei);
        mainCreasePatternWorker.unselect_all(false);
    }
}
