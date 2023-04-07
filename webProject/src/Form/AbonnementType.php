<?php

namespace App\Form;
use App\Entity\Abonnement;
use App\Entity\Offre;
use Doctrine\DBAL\Types\IntegerType;
use phpDocumentor\Reflection\Types\Integer;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\DateType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Validator\Constraints as Assert;
use App\Repository\OffreRepository;
use Symfony\Component\Validator\Context\ExecutionContextInterface;

class AbonnementType extends AbstractType
{
    private $offreRepository;

    public function __construct(OffreRepository $offreRepository)
    {
        $this->offreRepository = $offreRepository;
    }

    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('typeAb', ChoiceType::class, array(
                'choices' => array(
                    'Standard' => 'Standard',
                    'Premium' => 'Premium',
                    'Premium+' => 'Premium+',
                ),
                'placeholder' => 'Choose a subscription',
            ))
            ->add('dateDebut')
            ->add('dateFin')
            ->add('prixAb')
            ->add('idoffre', ChoiceType::class, array(
                'choices' => $this->offreRepository->getChoices(),
                'placeholder' => 'Choose an idoffre',
            ))
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Abonnement::class,
        ]);
    }
}